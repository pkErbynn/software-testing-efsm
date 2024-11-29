// EFSM

class GasPump {
    static SIDLE = 'IDLE';
    static S0 = 'S0';
    static S1 = 'S1';
    static S2 = 'S2';
    static S3 = 'S3';
    static S4 = 'S4';
    static S5 = 'S5';
    static S6 = 'S6';
    static SEND = 'END'; // STATE END

    constructor() {
        this.state = GasPump.SIDLE;

        this.Rprice = 0;
        this.Dprice = 0;
        this.k = 0;
        this.cashValue = 0;
        this.price = 0;
        this.G = 0;
        this.total = 0;
    }

    Activate(a, d) {
        if ( (a > 0) && (d > 0) && (this.state == GasPump.SIDLE)) {
            this.Rprice = a;
            this.Dprice = d;
            this.state = GasPump.S0;
            process.stdout.write('T1 -> ')
        }
    }

    Credit() {
        if (this.state === GasPump.S0) {
            this.state = GasPump.S2;
            process.stdout.write('T2 -> ')
        }
    }

    Cash(c) {
        if (c > 0 && this.state === GasPump.S0) {
            this.cashValue = c;
            this.k = 0;
            this.state = GasPump.S3; 
            process.stdout.write('T6 -> ')
        }
    }

    TurnOff() {
        if (this.state === GasPump.S0) {
            this.state = GasPump.SEND
            process.stdout.write('T20 -> ')
        }
    }

    Reject() {
        if (this.state === GasPump.S2) {
            this.state = GasPump.S0
            process.stdout.write('T3 -> ')
        }
    }

    Approved() {
        if (this.state === GasPump.S2) {
            this.k = 1;
            this.state = GasPump.S3
            process.stdout.write('T4 -> ')
        }
    }

    Cancel() {
        if (this.state === GasPump.S3) {
            this.state = GasPump.S0
            process.stdout.write('T5 -> ')
        }

        if (this.state === GasPump.S4) {
            this.state = GasPump.S0
            process.stdout.write('T19 -> ')
        }
    }

    Regular() {
        if (this.state === GasPump.S3) {
            this.price = this.Rprice;
            this.state = GasPump.S4
            process.stdout.write('T7 -> ')
        }
    }

    Diesel() {
        if (this.state === GasPump.S3) {
            this.price = this.Dprice;
            this.state = GasPump.S4
            process.stdout.write('T8 -> ')
        }
    }

    Start() {
        if (this.state === GasPump.S4 && this.k == 1 ) {
            this.G = 0;
            this.total = 0;
            this.state = GasPump.S1
            process.stdout.write('T18 -> ')
        }

        if (this.state === GasPump.S4 && this.k == 0 ) {
            this.G = 0;
            this.total = 0;
            this.state = GasPump.S5
            process.stdout.write('T9 -> ')
        }
    }

    Stop() {
        if (this.state === GasPump.S1) {
            this.state = GasPump.S6
            process.stdout.write('T16 -> ')
        }

        if (this.state === GasPump.S5) {
            this.state = GasPump.S6
            process.stdout.write('T11 -> ')
        }
    }

    Pump(){
        if (this.state === GasPump.S1) {
            this.G = this.G + 1;
            this.total = 1.1 * this.price * this.G;
            this.state = GasPump.S1
            process.stdout.write('T17 -> ')
        }

        if (this.state === GasPump.S5 && this.cashValue >= this.price * (this.G + 1)) {
            this.G = this.G + 1;
            this.total = this.price * this.G;
            this.state = GasPump.S5
            process.stdout.write('T10 -> ')
        }

        if (this.state === GasPump.S5 && this.cashValue < this.price * (this.G + 1)) {
            this.state = GasPump.S6
            process.stdout.write('T12 -> ')
        }
    }

    NoReceipt() {
        if (this.state === GasPump.S6) {
            this.state = GasPump.S0
            process.stdout.write('T14 -> ')
        }
    }

    Receipt() {
        if (this.state === GasPump.S6) {
            this.state = GasPump.S0
            process.stdout.write('T13 -> ')
            process.stdout.write(`(Print: ${this.G} and ${this.total}) `)
        }
    }

}

const gasPump = new GasPump();

// == #16
// gasPump.Activate(3.0, 4.0), gasPump.Cash(5),gasPump.Regular(), gasPump.Start(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.TurnOff(),
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()

// == #15
// gasPump.Activate(3.0, 4.0), gasPump.Cash(5),gasPump.Regular(), gasPump.Start(), gasPump.Stop()
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.TurnOff()


// // == t#14
// gasPump.Activate(3.0, 4.0), gasPump.Cash(5),gasPump.Regular(), gasPump.Start()
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()

// == t#13
// gasPump.Activate(3.0, 4.0), gasPump.Credit(),  gasPump.Approved(),gasPump.Regular()
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Approved(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()


// // == t#12
// gasPump.Activate(3.0, 4.0), gasPump.Credit(),  gasPump.Approved(),

// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Approved(), gasPump.Cash(2), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()


// // == t#11
// gasPump.Activate(3.0, 4.0), gasPump.Credit(),

// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Cancel(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()

// // == t#10
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Approved(), gasPump.Regular(), gasPump.Start()
// gasPump.Activate(-3.0, 4.0), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(-2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.NoReceipt(), gasPump.Receipt()

// // == t#9
// gasPump.Activate(3.0, 4.0), gasPump.Activate(-3.0, 4.0), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(-2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.Pump(), gasPump.NoReceipt(), gasPump.Receipt()

// // == t#8  ==all methods
// gasPump.Activate(-3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Cancel(), gasPump.Approved(), gasPump.Cash(2), gasPump.Regular(), gasPump.Diesel(), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Receipt(), gasPump.TurnOff()

// // == t#7
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Approved(), gasPump.Diesel(), gasPump.Start(), gasPump.Stop(), gasPump.Receipt(), gasPump.Cash(40), gasPump.Diesel(), gasPump.Start(),gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt()
// T1 -> T2 -> T4 -> T8 -> T18 -> T16 -> T13 -> (Print: 0 and 0) T6 -> T8 -> T9 -> T10 -> T11 -> T14 -> 


// == t#6
// gasPump.Activate(3.5, 4.0), gasPump.Credit(), gasPump.Approved(), gasPump.Cancel(), gasPump.Credit(), gasPump.Approved(), gasPump.Diesel(), gasPump.Cancel(), gasPump.Cash(1), gasPump.Regular(), gasPump.Cancel(),

// gasPump.Credit(), gasPump.Reject(), gasPump.TurnOff()
// T1 -> T2 -> T4 -> T5 -> T2 -> T4 -> T8 -> T19 -> T6 -> T7 -> T19 -> T2 -> T3 -> T20 -> 




// // == t#5
// gasPump.Activate(3.0, 4.0), gasPump.Credit(), gasPump.Reject(), gasPump.Cash(5.0), gasPump.Cancel(), gasPump.Cash(10), gasPump.Diesel(), gasPump.Cancel(), gasPump.Cash(4),gasPump.Regular(), gasPump.Start(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.TurnOff()
// // T1 -> T2 -> T3 -> T6 -> T5 -> T6 -> T8 -> T19 -> T6 -> T7 -> T9 -> T10 -> T12 -> T14 -> T20 -> 


// // == t#4
// gasPump.Activate(4, 5), gasPump.TurnOff()
// T1 -> T20 -> 


// == t#3
// gasPump.Activate(6, 4), gasPump.Credit(), gasPump.Reject(), gasPump.Credit(), gasPump.Approved(), gasPump.Cancel(), gasPump.Cash(10), gasPump.Diesel(), gasPump.Start(), gasPump.Stop(), gasPump.Receipt(), gasPump.TurnOff()
// // T1 -> T2 -> T3 -> T2 -> T4 -> T5 -> T6 -> T8 -> T9 -> T11 -> T13 -> (Print: 0 and 0) T20 -> 


// == t#2
// gasPump.Activate(3, 4), gasPump.Cash(1), gasPump.Regular(), gasPump.Start(), gasPump.Pump(), gasPump.NoReceipt(), gasPump.Credit(),
// gasPump.Approved(), gasPump.Regular(), gasPump.Start(), gasPump.Pump(), gasPump.Pump(), gasPump.Stop(), gasPump.NoReceipt(), gasPump.Cash(10.0),
// gasPump.Diesel(), gasPump.Cancel();
// gasPump.TurnOff()
// T1 -> T6 -> T7 -> T9 -> T12 -> T14 -> T2 -> T4 -> T7 -> T18 -> T17 -> T17 -> T16 ->
// T14 -> T6 -> T8 -> T19 -> T20

//=== test #1

// gasPump.Activate(6.5, 8.5)//t1
// gasPump.Cash(36.0);  // t6
// gasPump.Regular(); // t7 
// gasPump.Start();  // t9
// gasPump.Pump(); // t10
// gasPump.Pump(); // t10
// gasPump.Pump();  // t10
// gasPump.Pump(); // t10
// gasPump.Pump(); // t12
// gasPump.Receipt(); // t13
// gasPump.Credit(); //t2
// gasPump.Approved();  //t4
// gasPump.Cancel(); //t5
// gasPump.TurnOff(); //t20


// ==========

// ===========================

// // test 6
// // 1. Activate the pump with a price per gallon (e.g., $5 per gallon)
// gasPump.activate(5);  // Outputs: T1 ->

// // 2. Start the pump
// gasPump.start();  // Outputs: T2 ->

// // 3. Pay with cash (e.g., $12, which is enough for more than 2 gallons)
// gasPump.cash(12);  // Outputs: T5 ->

// // 4. Start the pumping process (cash mode)
// gasPump.startPump();  // Outputs: T10 ->

// // 5. Pump the first gallon (this will produce T8 since the cash is sufficient)
// gasPump.pump();  // Outputs: T8 ->

// // 6. Pump again, but this time the remaining cash ($2) is insufficient for another gallon ($5 per gallon)
// gasPump.pump();  // Outputs: T9 ->



// // test 6
// gasPump.activate(100);
// gasPump.start();
// gasPump.cash(2);
// gasPump.startPump();
// gasPump.pump();
// gasPump.start();

//T1 -> T2 -> T3 -> T6 -> T10 -> T12 -> T11 -> 
//T1 -> T2 -> T5 -> T10 -> T8 -> T9 -> 
//T1 -> T2 -> T3 -> T4 -> T2 -> T3 -> T6 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> T12 -> T11 -> 
//T1 -> T2 -> T3 -> T6 -> T10 -> T11 -> T2 -> T5 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> 
//t5: T1 -> T2 -> T5 -> T10 -> T8 -> T8 -> T11 -> 
//t6: T1 -> T2 -> T5 -> T10 -> T9 -> T2 -> 


// test 5
// gasPump.activate(2);
// gasPump.start();
// gasPump.cash(100);
// gasPump.startPump();
// gasPump.pump();
// gasPump.pump();
// gasPump.stop();

//T1 -> T2 -> T3 -> T6 -> T10 -> T12 -> T11 -> 
//T1 -> T2 -> T5 -> T10 -> T8 -> T9 -> 
//T1 -> T2 -> T3 -> T4 -> T2 -> T3 -> T6 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> T12 -> T11 -> 
//T1 -> T2 -> T3 -> T6 -> T10 -> T11 -> T2 -> T5 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> 
//t5: T1 -> T2 -> T5 -> T10 -> T8 -> T8 -> T11 -> 


// test 4
// gasPump.activate(5);
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.startPump();
// gasPump.stop();
// gasPump.start();
// gasPump.cash(5);
// gasPump.cancel();
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.startPump();
// gasPump.pump();

//T1 -> T2 -> T3 -> T6 -> T10 -> T12 -> T11 -> 
//T1 -> T2 -> T5 -> T10 -> T8 -> T9 -> 
//T1 -> T2 -> T3 -> T4 -> T2 -> T3 -> T6 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> T12 -> T11 -> 
//T1 -> T2 -> T3 -> T6 -> T10 -> T11 -> T2 -> T5 -> T7 -> T2 -> T3 -> T6 -> T10 -> T12 -> 


// test 3
// gasPump.activate(5);
// gasPump.start();
// gasPump.debit();
// gasPump.reject();
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.cancel();
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.startPump();
// gasPump.pump();
// gasPump.pump();
// gasPump.stop();



// test 2
// gasPump.activate(5);
// gasPump.start();
// gasPump.cash(6);
// gasPump.startPump();
// gasPump.pump();
// gasPump.pump();

//T1 -> T2 -> T3 -> T6 -> T10 -> T12 -> T11 -> 
//T1 -> T2 -> T5 -> T10 -> T8 -> T9 -> 


// test 1
// gasPump.activate(15);
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.startPump();
// gasPump.pump();
// gasPump.stop();

// test sample 1
// gasPump.activate(5);
// gasPump.start();
// gasPump.debit();
// gasPump.approved();
// gasPump.startPump();
// gasPump.pump();
// gasPump.stop();






// type data flow
// function F(a, b, c) { let type; let i; let t;  process.stdout.write(`Inputs(${a}, ${b}, ${c}) => ` ); process.stdout.write('type ASSIGNED @1 ->')
//     type = 0; process.stdout.write('type RE-ASSIGNED @2 ->')
//     i = 0;
//     while (i <= 1) {     
//         if (a >= c) {   
//             t = a; 
//             a = c;
//             c = t;  }   
//         if (b >= c) {   
//             t = b;
//             b = c;
//             c = t;  }   
//         if (a + b <= c) {   
//             type = -1; process.stdout.write('type RE-ASSIGNED @14 ->')  }   
//         process.stdout.write('type used @15 ->'); if (type >= 0) {    
//             if (a === c || b === c) { 
//                 type = type + 1; process.stdout.write('type used + RE-ASSIGNED @17 ->')    }   
//             process.stdout.write('type used @18 ->'); if (type === 0 && a === b) {    
//                 type = type + 1; process.stdout.write('type used + RE-ASSIGNED @19 ->');    }   }   
//         i = i + 1;  }   
//         process.stdout.write('type used @21 ->'); return type;    }

// F(1, 1, 1)
// F(5, 3, 5)
// F(3, 5, 3)
// F(1, 1, 3)
// F(5, 6, 3)
// F(5, 5, 5)
// F(5, 15, 5)
// F(5, 5, 0)
// F(0, 3, 2)
// F(13, 0, 2)

// "A" DATA-FLOW
// function F(a, b, c) { let type; let i; let t;  process.stdout.write(`Inputs(${a}, ${b}, ${c}) => ` ); process.stdout.write('a ASSIGNED @1 ->')
//     type = 0; 
//     i = 0;
//     while (i <= 1) {     
//         process.stdout.write('a used @5 ->'); if (a >= c) {   
//             t = a;  process.stdout.write('a used @6 ->')
//             a = c;  process.stdout.write('a re-ASSIGNED @7 ->')
//             c = t;  }   
//         if (b >= c) {   
//             t = b;
//             b = c;
//             c = t;  }   
//         process.stdout.write('a used @13 ->'); if (a + b <= c) {   
//             type = -1;  }   
//         if (type >= 0) {    
//             process.stdout.write('a used @16 ->'); if (a === c || b === c) { 
//                 type = type + 1;    }   
//             process.stdout.write('a used @18 ->'); if (type === 0 && a === b) {    
//                 type = type + 1;    }   }   
//         i = i + 1;  }   
//     return type;    }

// F(1, 1, 1)


// VERIFY PREVIOUS
/*
function F(a, b, c) { let type; let i; let t;
    type = 0; 
    i = 0; // let status4 = false; let status5 = false; let status9 = false; let status13 = false; let status15 = false; let status16 = false; let status18 = false;
    while (i <= 1) {     process.stdout.write('4T -> ')
        if (a >= c) {   process.stdout.write('5T -> ')
            t = a;
            a = c;
            c = t;  }   process.stdout.write('5F -> ')
        if (b >= c) {   process.stdout.write('9T -> ')
            t = b;
            b = c;
            c = t;  }   process.stdout.write('9F -> ')
        if (a + b <= c) {   process.stdout.write('13T -> ')
            type = -1;  }   process.stdout.write('13F -> ')
        if (type >= 0) {    process.stdout.write('15T -> ')
            if ( (a === c) || (b === c) ) {   process.stdout.write('16T -> ')
                if (((a === c) == true) && ((b === c) == true))
                {
                    process.stdout.write('(T T) -> ')
                }
                if (((a === c) == true) && ((b === c) == false))
                {
                    process.stdout.write('(T F) -> ')
                }
                if (((a === c) == false) && ((b === c) == true))
                {
                    process.stdout.write('(F T) -> ')
                }
                if (((a === c) == false) && ((b === c) == false))
                {
                    process.stdout.write('(F F) -> ')
                }
                type = type + 1;    }   process.stdout.write('16F -> ')
            if ( (type === 0) && (a === b) ) {    process.stdout.write('18T -> ')
                if (((type === 0) == true) && ((a === b) == true))
                {
                    process.stdout.write('Type (T T) -> ')
                }
                if (((type === 0) == true) && ((a === b) == false))
                {
                    process.stdout.write('Type (T F) -> ')
                }
                if (((type === 0) == false) && ((a === b) == true))
                {
                    process.stdout.write('Type (F T) -> ')
                }
                if (((type === 0) == false) && ((a === b) == false))
                {
                    process.stdout.write('Type (F F) -> ')
                }
                type = type + 1;    } process.stdout.write('18F -> ')  }   process.stdout.write('15F -> ')
        i = i + 1;  }   process.stdout.write('4F -> ')
    return type;    }

F(0, 0, 10)

*/


