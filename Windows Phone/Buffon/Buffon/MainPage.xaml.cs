using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Windows.UI.Popups; 
using Microsoft.Phone.Controls;

namespace Buffon
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Constructor
        public MainPage()
        {
            InitializeComponent();
            generarLineas();
        }

        private void generarLineas()
        {
            for (int i = 0; i < 6; i++)
            {
                int pix = i * 100;
                Line lineP = new Line();
                lineP.Stroke = new SolidColorBrush(Colors.Green);
                lineP.StrokeThickness = 1;

                Point point1 = new Point();
                point1.X = 0;
                point1.Y = (100 * i);

                Point point2 = new Point();
                point2.X = 480;
                point2.Y = (100 * i);

                lineP.X1 = point1.X;
                lineP.Y1 = point1.Y;
                lineP.X2 = point2.X;
                lineP.Y2 = point2.Y;

                this.myCanvas.Children.Add(lineP);

            }
        }

        private void GoToAbout(object sender, GestureEventArgs e)
        {
            this.NavigationService.Navigate(new Uri("/About.xaml", UriKind.RelativeOrAbsolute));
        }

        private void Generar_Tap(object sender, GestureEventArgs e) 
        {
            //draw lines on canvas
            myCanvas.Children.Clear();
            generarLineas();
            myTextBlock.Text = "Numero Cercano a π";
            double numTiros = Convert.ToDouble(Tiros.Text);
            double length = 100;
            double angle = 0;
            double contador = 0;
            double pi = 0;

            Random rndA = new Random();   
            
            for (int i = 0; i < numTiros; i++)
            {
                Line line = new Line();
                line.StrokeThickness = 1;
                angle = rndA.Next(360);
                Point point1 = new Point(rndA.Next(281)+100, rndA.Next(301)+100);
               
                double angleRadians = (Math.PI / 180.0) * angle;
                Point point2 = new Point((int)(point1.X + (Math.Sin(angleRadians) * length)), (int)(point1.Y + (Math.Cos(angleRadians) * length)));
             
                line.X1 = point1.X;
                line.Y1 = point1.Y;
                line.X2 = point2.X;
                line.Y2 = point2.Y;

                if (Interseccion(point1.Y, point2.Y))
                {
                    contador++;
                    line.Stroke = new SolidColorBrush(Colors.Red);
                }
                else
                {
                    line.Stroke = new SolidColorBrush(Colors.Yellow);
                }

                this.myCanvas.Children.Add(line);                
            }
            
            pi = (2d *numTiros) / ( contador);
            myTextBlock.Text = myTextBlock.Text+"\n"+pi.ToString()+"\n\nNumero de Intersecciones\n"+contador;
        }

        bool Interseccion(double y, double y2)
        {
            y = y / 1000 * 10;
            y2 = y2 / 1000 * 10;

            return (int)(y) != (int)(y2);   
        }

        private void Tiros_GotFocus(object sender, RoutedEventArgs e)
        {
            TextBox tb = (TextBox)sender;
            tb.Text = string.Empty;
            tb.GotFocus -= Tiros_GotFocus;
        }

        private void GoToAbout(object sender, EventArgs e)
        {
            this.NavigationService.Navigate(new Uri("/About.xaml", UriKind.RelativeOrAbsolute));
        }

        

        
    }
}
