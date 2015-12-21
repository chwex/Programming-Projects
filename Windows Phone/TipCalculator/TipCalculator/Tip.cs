using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TipCalculator
{
    public class Tip
    {
        public string BillAmmount { get; set; }
        public string TipAmmount { get; set; }
        public string TotalAmmount { get; set; }

        public Tip()
        {
            this.BillAmmount = String.Empty;
            this.TipAmmount = String.Empty;
            this.TotalAmmount = String.Empty;
        }

        public void CalculateTip(string originalAmmount, double tipPercentage)
        {
            double billAmmount = 0.0;
            double tipAmmount = 0.0;
            double totalAmmount = 0.0;

            if(double.TryParse(originalAmmount.Replace('$', ' '), out billAmmount))
            {
                tipAmmount = billAmmount * tipPercentage;
                totalAmmount = billAmmount + tipAmmount;
            }

            this.BillAmmount = String.Format("{0:C}", billAmmount);
            this.TipAmmount = String.Format("{0:C}", tipAmmount);
            this.TotalAmmount = String.Format("{0:C}", totalAmmount);

        }

    }
}
