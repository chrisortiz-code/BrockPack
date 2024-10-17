class CarNode {
    public Car item; // value stored in the node
    public CarNode next; // reference to the next node

    CarNode(Car car, CarNode node) {
        this.item=car;
        this.next=node;
    }
}
