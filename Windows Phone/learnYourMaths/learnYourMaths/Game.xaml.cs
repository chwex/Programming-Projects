using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.Threading;
using System.Windows.Threading;
using System.Windows.Media;
using Microsoft.Devices;
using System.Windows.Media.Imaging;

namespace learnYourMaths
{
    public partial class Game : PhoneApplicationPage
    {
        int points = 0;
        int round = 0;
        bool check = false;
        int flag = 0;
        private DispatcherTimer dispatcherTimer;
        Color colorTel = (Color)Application.Current.Resources["PhoneAccentColor"];
        
        public Game()
        {
            InitializeComponent();

            dispatcherTimer = new System.Windows.Threading.DispatcherTimer();
            dispatcherTimer.Tick += new EventHandler(gameCycle);
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0);
            dispatcherTimer.Start();
            
            
        }

        public void gameCycle(object sender, EventArgs e)
        {
            dispatcherTimer.Interval = new TimeSpan(0, 0, 6);
            Dispatcher.BeginInvoke(delegate()
            {
                ansBlock1.Visibility = System.Windows.Visibility.Visible;
                ansBlock2.Visibility = System.Windows.Visibility.Visible;
                ansBlock3.Visibility = System.Windows.Visibility.Visible;
                int n1 = 0;
                int n2 = 0;

                Random rand = new Random();

                round++;
                check = false;
                n1 = rand.Next(13);
                n2 = rand.Next(13);
                int ansc = n1 * n2;


                int ansI1 = n1 * rand.Next(13);
                int ansI2 = n2 * rand.Next(13);

           
                MainBlock.Text = n1 + " x " + n2 + " = ";
                int[] numeros = { ansI1, ansI2, ansc };

                score.Text = "Round: " + round + "\t\tScore: " + points;

                numeros = shuffnums(numeros);

                ansBlock1.Text = numeros[0].ToString();
                ansBlock1.Tag = ansc;


                ansBlock2.Text = numeros[1].ToString();
                ansBlock2.Tag = ansc;


                ansBlock3.Text = numeros[2].ToString();
                ansBlock3.Tag = ansc;
            });
            restore();
            flag++;
            dispatcherTimer.Interval = new TimeSpan(0, 0, 6);
            if (flag == 100)
                dispatcherTimer.Stop();
        }

        private void onTouch1(object sender, System.Windows.Input.GestureEventArgs e)
        {
            vibrar();
            HitMaker.Play();
            if (ansBlock1.Text == ansBlock1.Tag.ToString())
            {
                
                Correcto.Play();
                points++;
                CoIn.Foreground = new SolidColorBrush(Colors.Green);
                CoIn.Text = "Correcto";
                ansBlock1.IsHitTestVisible = false;
                ansBlock1.Foreground = new SolidColorBrush(Colors.Green);
            }
            else
            {
               
                Incorrecto.Play();
                CoIn.Foreground = new SolidColorBrush(Colors.Red);
                CoIn.Text = "Incorrecto \n Correct answer: " + ansBlock1.Tag.ToString(); ;
            }
            score.Text = "Round: " + round + "\t\tScore: " + points;
            check = true;
            ansBlock2.Visibility = System.Windows.Visibility.Collapsed;
            ansBlock3.Visibility = System.Windows.Visibility.Collapsed;
        }

        private void onTouch2(object sender, System.Windows.Input.GestureEventArgs e)
        {
            vibrar();
            HitMaker.Play();
            if (ansBlock2.Text == ansBlock2.Tag.ToString())
            {
                
                Correcto1.Play();
                ansBlock2.Foreground = new SolidColorBrush(Colors.Green);
                CoIn.Foreground = new SolidColorBrush(Colors.Green);
                points++;
                CoIn.Text = "Correcto";
                ansBlock2.IsHitTestVisible = false;
            }
            else
            {
               
                Incorrecto1.Play();
                CoIn.Foreground = new SolidColorBrush(Colors.Red);
                CoIn.Text = "Incorrecto\n Correct answer: " + ansBlock1.Tag.ToString(); ;
            }
            score.Text = "Round: " + round + "\t\tScore: " + points;
            check = true;
            ansBlock1.Visibility = System.Windows.Visibility.Collapsed;
            ansBlock3.Visibility = System.Windows.Visibility.Collapsed;
        }

        private void onTouch3(object sender, System.Windows.Input.GestureEventArgs e)
        {
            HitMaker.Play();
            vibrar();
            if (ansBlock3.Text == ansBlock3.Tag.ToString())
            {
                
                Correcto2.Play();
                points++;
                CoIn.Foreground = new SolidColorBrush(Colors.Green);
                ansBlock3.Foreground = new SolidColorBrush(Colors.Green);
                CoIn.Text = "Correcto";
                ansBlock3.IsHitTestVisible = false;
            }
            else
            {
                
                Incorrecto2.Play();
                CoIn.Foreground = new SolidColorBrush(Colors.Red);
                CoIn.Text = "Incorrecto\n Correct answer: " + ansBlock1.Tag.ToString(); ;
            }

            score.Text = "Round: " + round + "\t\tScore: " + points;
            check = true;
            ansBlock1.Visibility = System.Windows.Visibility.Collapsed;
            ansBlock2.Visibility = System.Windows.Visibility.Collapsed; 
        }

        private int[] shuffnums(int[] numeros)
        {
            Random rnd = new Random();
            int[] numerosRand = numeros.OrderBy(x => rnd.Next()).ToArray();
            return numerosRand;

        }

        private void restore()
        {
            SolidColorBrush backColor = new SolidColorBrush(colorTel);
            ansBlock1.Foreground = backColor;
            ansBlock1.IsHitTestVisible = true;
            ansBlock2.Foreground = backColor;
            ansBlock2.IsHitTestVisible = true;
            ansBlock3.Foreground = backColor;
            ansBlock3.IsHitTestVisible = true;
            CoIn.Text = "";
        }

        private void vibrar()
        {
            VibrateController vibrate = VibrateController.Default;
            vibrate.Start(TimeSpan.FromMilliseconds(800));
        }

        public PhoneApplicationFrame RootFrame { get; set; }
    }
}