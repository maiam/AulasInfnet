package br.com.infnet.moedas;

public class Moeda {
    
    private double real;
    private double dolar;
    private double euro;

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
        this.dolar = real / 2;
        this.euro = real / 3;
    }

    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
        this.real = dolar * 2;
        this.euro = this.real / 3;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
        this.real = euro * 3;
        this.dolar = real / 2;
    }
    
}
