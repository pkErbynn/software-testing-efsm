package org.example;

public class GasPumpJava {
    private float Rprice;
    private float Dprice;
    private int w;
    private float price;
    private int L;
    private float total;
    private float cash;
    private int k;

    public GasPumpJava() {
        Rprice = 0;
        Dprice = 0;
        w = 0;
        price = 0;
        L = 0;
        total = 0;
        cash = 0;
        k = -1;
    }

    public final int Activate(float a, float d) {
        if ((k == -1) && (a > 0) && (d > 0)) {
//			===
//			if (((k == -1) == true) && ((a > 0) == true) && ((d > 0) == true))
//			{
//				System.out.print("(T T T) ->");
//			}
//			if (((k == -1) == true) && ((a > 0) == true) && ((d > 0) == false))
//			{
//				System.out.print("(T T F) ->");
//			}
//
//			if (((k == -1) == true) && ((a > 0) == false) && ((d > 0) == true))
//			{
//				System.out.print("(T F T) ->");
//			}
//
//			if (((k == -1) == true) && ((a > 0) == false) && ((d > 0) == false))
//			{
//				System.out.print("(T F F) ->");
//			}
//
//			if (((k == -1) == false) && ((a > 0) == true) && ((d > 0) == true))
//			{
//				System.out.print("(F T T) ->");
//			}
//			if (((k == -1) == false) && ((a > 0) == true) && ((d > 0) == false))
//			{
//				System.out.print("(F T F) ->");
//			}
//			if (((k == -1) == false) && ((a > 0) == false) && ((d > 0) == true))
//			{
//				System.out.print("(F F T) ->");
//			}
//
//			if (((k == -1) == false) && ((a > 0) == false) && ((d > 0) == false))
//			{
//				System.out.print("(F F F) ->");
//			}

//			===
            k = 0;
            Rprice = a;
            Dprice = d;
            System.out.print("GAS PUMP IS ON");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }

    }

    public final int Credit() {

        if (k == 0) {
            k = 2;
            System.out.print("CHECKING CREDIT CARD.");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Reject() {
        if (k == 2) {
            k = 0;
            System.out.print("CREDIT CARD IS REJECTED.");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Cancel() {
//        if((this.k == 3) == true && (this.k == 4) == true)
//        {
//            System.out.print("(T, T) ->");
//        }
//
//        if((this.k == 3) == true && (this.k == 4) == false)
//        {
//            System.out.print("(T, F) ->");
//        }
//
//        if((this.k == 3) == false && (this.k == 4) == true)
//        {
//            System.out.print("(F T) ->");
//        }
//
//        if((this.k == 3) == false && (this.k == 4) == false)
//        {
//            System.out.print("(F F) ->");
//        }


        if ((k == 3) || (k == 4)) {
            k = 0;
            System.out.print("TRANSACTION IS CANCELLED.");
            System.out.print("\n");

//            if((w == 0) == true)
//            {
//                System.out.print("(T) ->");
//            }
//            if((w == 0) == false)
//            {
//                System.out.print("(F) ->");
//            }

            if (w == 0) {
                System.out.print("$");
                System.out.print(cash);
                System.out.print(" OF CASH IS RETURNED");
                System.out.print("\n");
            }
            return 1;
        } else {
            return 0;
        }
    }

    public final int Approved() {
//        if((this.k == 2) == true)
//        {
//            System.out.print("k == 2 (T) ->");
//        }
//
//        if((this.k == 2) == false)
//        {
//            System.out.print("k == 2 (F) ->");
//        }
        if (k == 2) {
            k = 3;
            w = 1;
            System.out.print("CREDIT CARD APPROVED.");
            System.out.print("\n");
            System.out.print("SELECT TYPE OF GASOLINE:");
            System.out.print("\n");
            System.out.print("a. REGULAR");
            System.out.print("\n");
            System.out.print("b. DIESEL");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Cash(float c) {
//        if((this.k == 0) == true)
//        {
//            System.out.print("k == 0 (T) ->");
//        }
//
//        if((this.k == 0) == false)
//        {
//            System.out.print("k == 0 (F) ->");
//        }
        if (k == 0) {
            k = 3;
            w = 0;
            cash = c;
            System.out.print("SELECT TYPE OF GASOLINE:");
            System.out.print("\n");
            System.out.print("a. REGULAR");
            System.out.print("\n");
            System.out.print("b. DIESEL");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Regular() {
//        if((this.k == 3) == true)
//        {
//            System.out.print("k == 3 (T) ->");
//        }
//
//        if((this.k == 3) == false)
//        {
//            System.out.print("k == 3 (F) ->");
//        }
        if (k == 3) {
            k = 4;
            System.out.print("REGULAR IS SELECTED.");
            System.out.print("\n");
            price = Rprice;

//            if((this.w == 1) == true)
//            {
//                System.out.print("w == 1 (T) ->");
//            }
//
//            if((this.w == 1) == false)
//            {
//                System.out.print("w == 1 (F) ->");
//            }
            if (w==1) price= 1.1f*price;
            return 1;
        } else {
            return 0;
        }
    }


    public final int Diesel() {
//        if((this.k == 3) == true)
//        {
//            System.out.print("k == 3: (T) ->");
//        }
//        if((this.k == 3) == false)
//        {
//            System.out.print("k == 3: (F) ->");
//        }

        if (k == 3) {
            k = 4;
            System.out.print("DIESEL IS SELECTED.");
            System.out.print("\n");
            price = Dprice;
            return 1;
        } else {
            return 0;
        }
    }

    public final int Start() {
//        if((this.k == 4) == true)
//        {
//            System.out.print("k == 4: (T) ->");
//        }
//        if((this.k == 4) == false)
//        {
//            System.out.print("k == 4: (F) ->");
//        }
        if (k == 4) {
            k = 5;
            L = 0;
            total = 0;
            System.out.print("PUMP IS READY TO DISPOSE ");
            System.out.print("\n");
            System.out.print("# OF GALLONS PUMPED: ");
            System.out.print(L);
            System.out.print("\n");
            System.out.print("TOTAL CHARGE: $");
            System.out.print(total);
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Pump() {
//        if((this.k == 5) == true)
//        {
//            System.out.print("k == 5: (T) ->");
//        }
//        if((this.k == 5) == false)
//        {
//            System.out.print("k == 5: (F) ->");
//        }
        if (k == 5) {
//            if((this.w == 1) == true && (this.cash > this.price * (this.L + 1)) == true && (w == 0) == true)
//            {
//                System.out.print("many args: (T, T, T) ->");
//            }
//            if((this.w == 1) == true && (this.cash > this.price * (this.L + 1)) == true && (w == 0) == false)
//            {
//                System.out.print("many args: (T, T, F) ->");
//            }
//            if((this.w == 1) == true && (this.cash > this.price * (this.L + 1)) == false && (w == 0) == true)
//            {
//                System.out.print("many args: (T, F, T) ->");
//            }
//            if((this.w == 1) == true && (this.cash > this.price * (this.L + 1)) == false && (w == 0) == false)
//            {
//                System.out.print("many args: (T, F, F) ->");
//            }
//
//            if((this.w == 1) == false && (this.cash > this.price * (this.L + 1)) == true && (w == 0) == true)
//            {
//                System.out.print("many args: (F, T, T) ->");
//            }
//            if((this.w == 1) == false && (this.cash > this.price * (this.L + 1)) == true && (w == 0) == false)
//            {
//                System.out.print("many args: (F, T, F) ->");
//            }
//            if((this.w == 1) == false && (this.cash > this.price * (this.L + 1)) == false && (w == 0) == true)
//            {
//                System.out.print("many args: (F, F, T) ->");
//            }
//            if((this.w == 1) == false && (this.cash > this.price * (this.L + 1)) == false && (w == 0) == false)
//            {
//                System.out.print("many args: (F, F, F) ->");
//            }

            // ========
//            if((this.w == 0) == true && (this.cash < this.price * (this.L + 1)) == true)
//            {
//                System.out.print("lesser args: (T, T) ->");
//            }
//            if((this.w == 0) == true && (this.cash < this.price * (this.L + 1)) == false)
//            {
//                System.out.print("lesser args: (T, F) ->");
//            }
//            if((this.w == 0) == false && (this.cash < this.price * (this.L + 1)) == true)
//            {
//                System.out.print("lesser args: (F, T) ->");
//            }
//            if((this.w == 0) == false && (this.cash < this.price * (this.L + 1)) == false)
//            {
//                System.out.print("lesser args: (F, F) ->");
//            }
//
            // =====
//            if((this.w == 0) == true && (total < cash) == true)
//            {
//                System.out.print("(T, T) ->");
//            }
//            if((this.w == 0) == true && (total < cash) == false)
//            {
//                System.out.print("(T, F) ->");
//            }
//            if((this.w == 0) == false && (total < cash) == true)
//            {
//                System.out.print("(F, T) ->");
//            }
//            if((this.w == 0) == false && (total < cash) == false)
//            {
//                System.out.print("lesser args: (F, F) ->");
//            }

            if ((w == 1) || ((cash > price * (L + 1)) && (w == 0))) {
                L = L + 1;
                total = L * price;
                System.out.print("# OF GALLONS PUMPED: ");
                System.out.print(L);
                System.out.print("\n");
                System.out.print("TOTAL CHARGE: $");
                System.out.print(total);
                System.out.print("\n");
                System.out.print("CONTINUE PUMPING");
                System.out.print("\n");
                return 1;
            } else if ((w == 0) && (cash < price * (L + 1))) {
                k = 6;
                System.out.print("PUMP STOPPED. NOT SUFFICIENT FUNDS. ");
                System.out.print("\n");
                System.out.print("# OF GALLONS PUMPED: ");
                System.out.print(L);
                System.out.print("\n");
                System.out.print("TOTAL CHARGE: $");
                System.out.print(total);
                System.out.print("\n");

//                if((this.w == 0) == true && (total < cash) == true)
//                {
//                    System.out.print("(T, T) ->");
//                }

//                if((this.w == 0) == true && (total < cash) == false)
//                {
//                    System.out.print("(total < cash):: (T, F) @ Pump()->");
//                }

//                if((this.w == 0) == false && (total < cash) == true)
//                {
//                    System.out.print("(F, T) ->");
//                }
//                if((this.w == 0) == false && (total < cash) == false)
//                {
//                    System.out.print("lesser args: (F, F) ->");
//                }

                if ((w == 0) && (total < cash)) {
                    System.out.print("$");
                    System.out.print(cash - total);
                    System.out.print(" OF CASH IS RETURNED");
                    System.out.print("\n");
                }
                System.out.print("DO YOU WANT A RECEIPT?");
                System.out.print("\n");
                return 1;
            }
            ;
        }
        ;
        return 0;
    }

    public final int Stop() {
//        if((this.k == 5) == true)
//        {
//            System.out.print("k == 5: (T) ->");
//        }
//        if((this.k == 5) == false)
//        {
//            System.out.print("k == 5: (F) ->");
//        }
        if (k == 5) {
            k = 6;
            System.out.print("PUMP STOPPED. ");
            System.out.print("\n");
            System.out.print("# OF GALLONS PUMPED: ");
            System.out.print(L);
            System.out.print("\n");
            System.out.print("TOTAL CHARGE: $");
            System.out.print(total);
            System.out.print("\n");


//            if((this.w == 0) == true && (total < cash) == true)
//            {
//                System.out.print("(T, T) ->");
//            }
            if((this.w == 0) == true && (total < cash) == false)
            {
                System.out.print("(total < cash):: (T, F) @ Stop() ->");
            }
//            if((this.w == 0) == false && (total < cash) == true)
//            {
//                System.out.print("(F, T) ->");
//            }
//            if((this.w == 0) == false && (total < cash) == false)
//            {
//                System.out.print("(F, F) ->");
//            }


            if ((w == 0) && (total < cash)) {
                System.out.print("$");
                System.out.print(cash - total);
                System.out.print(" OF CASH IS RETURNED");
                System.out.print("\n");
            }
            System.out.print("DO YOU WANT A RECEIPT?");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int NoReceipt() {
//                if((this.k == 6) == true)
//        {
//            System.out.print("k == 6: (T) ->");
//        }
//        if((this.k == 6) == fal se)
//        {
//            System.out.print("k == 6: (F) ->");
//        }
        if (k == 6) {
            k = 0;
            System.out.print("NO RECEIPT IS PRINTED ");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int Receipt() {
//        if((this.k == 6) == true)
//        {
//            System.out.print("k == 6: (T) ->");
//        }
//        if((this.k == 6) == false)
//        {
//            System.out.print("k == 6: (F) ->");
//        }
        if (k == 6) {
            k = 0;
            System.out.print("RECEIPT IS PRINTED: ");
            System.out.print("\n");
            System.out.print("# OF GALLONS PUMPED: ");
            System.out.print(L);
            System.out.print("\n");
            System.out.print("TOTAL CHARGE: $");
            System.out.print(total);
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }

    public final int TurnOff() {
        if((this.k == 0) == true)
        {
            System.out.print("k == 0: (T) ->");
        }
        if((this.k == 0) == false)
        {
            System.out.print("k == 0: (F) ->");
        }

        if (k == 0) {
            k = -2;
            System.out.print("GAS PUMP IS TURNED OFF ");
            System.out.print("\n");
            return 1;
        } else {
            return 0;
        }
    }
}
