interface CurrentAddress {
    default void PrintAddress() {
        System.out.println("This is Current Addresss");
    }
}

interface PermanentAddress {
    default void PrintAddress() {
        System.out.println("This is Permanent Address");
    }
}

class AddressDetails implements CurrentAddress, PermanentAddress {
    public void PrintAddress() {
        CurrentAddress.super.PrintAddress();
        PermanentAddress.super.PrintAddress();
    }

    public static void main(String[] args) {
        AddressDetails addressDetails=new AddressDetails();
        addressDetails.PrintAddress();
    }
}