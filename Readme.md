## Object-Oriented and Model-Based Testing

The goal of this project is to test GasPump class that exhibits state behavior specified by
the EFSM model. The source code of the class GasPump is provided in a separate file.

### EFSM-MDA for GasPump Class Model
![efsm gasspump diagram](./Project%20Description/mda-diagram.png)

### Description of the GasPump class:
The following operations are supported by the GasPump class:

```
GasPump()               //constructor
int Activate (float a, float d) // the gas pump is activated where a represents the
                            // price of Regular gas; d represents the price of Diesel gas
int Credit()            // pay for gas by a credit card
int Reject()            // credit card is rejected
int Cancel()            // cancel the transaction
int Approved()          // credit card is approved
int Cash(float c)       // pay for gas by cash, where c represents prepaid cash
int Regular()           // Regular gas is selected
int Diesel()            // Diesel gas is selected
int Start()             // start pumping gas
int Pump()              // one Gallon of gas is disposed
int Stop()              // stop pumping gas
int NoReceipt()         // no receipt
int Receipt()           // receipt is printed
int TurnOff()           // gas pump is turned off
```

Unless stated differently, each method (operation) returns 1 when the operation is
successfully completed; otherwise, a zero (0) value is returned.

The GasPump class is a state-based class that is used to control a simple gas pump. Users
can pay by cash or with a credit card. The gas pump disposes two types of gasoline:
Regular and Diesel. The price of each type of gasoline is provided when the gas pump is
activated. The detailed behavior of the GasPump class is specified by the EFSM model.
Notice that the EFSM model specifies the expected behavior of the GasPump class.