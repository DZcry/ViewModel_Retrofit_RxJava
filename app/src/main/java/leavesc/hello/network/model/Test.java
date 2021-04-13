package leavesc.hello.network.model;

public class Test {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private boolean ifVip;

        public boolean isIfVip() {
            return ifVip;
        }

        public void setIfVip(boolean ifVip) {
            this.ifVip = ifVip;
        }
    }

}
