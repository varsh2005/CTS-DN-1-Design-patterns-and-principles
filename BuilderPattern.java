public class BuilderPattern{
    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
        }
        public void show() {
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
        }
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }
            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer.Builder builder = new Computer.Builder();
        builder.setCPU("Intel i5");
        builder.setRAM("8GB");
        builder.setStorage("256GB SSD");
        Computer basicComputer = builder.build();
        System.out.println("Basic Computer Configuration:");
        basicComputer.show();
    }
}
