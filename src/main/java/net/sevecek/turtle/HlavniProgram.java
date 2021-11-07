package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

public class HlavniProgram {
    Turtle zofka;

    public void main(String[] args) {
        //Turtle zofka;

        zofka = new Turtle();

        //Metody na kreslení čtverce, trojuhelníku, obdélníku, kolečka s pevnými velkostmi stran:

        //Čtverec s pevnou velikostí strany 100

        for (int i = 0; i < 4; i++) {
            zofka.move(100);
            zofka.turnRight(90);
        }

        //Rovnoramenný trojúhelník s velikostí strany 100 a úhlem 120

        for (int i = 0; i < 3; i++) {
            zofka.move(100);
            zofka.turnRight(120);
        }

        //Obdélník s velikostí strany 100 a 200

        for (int i = 0; i < 2; i++) {
            zofka.move(100);
            zofka.turnRight(90);
            zofka.move(200);
            zofka.turnRight(90);
        }

        //Kolečko o průměru 229 (zhruba)

        for (int i = 0; i < 360; i++) {
            zofka.turnRight(1);
            zofka.move(2);
        }

        //Metody pro volitelné velikosti stran čtverce, obdélníku, trojuhelníku, kolečka:

        nakresliCtverec(140);

        nakresliTrojuhelnik(100, 130);

        nakresliObdelnik(100, 300);

        nakresliKolecko(300);

        //Kreslení obrázků pomocí metod:

        //Zmrzlina
        nakresliZmrzlinu(150, 45);

        //Snehulak
        nakresliSnehulaka();

        //Mašinka
        nakresliMasinku();
    }

    public void nakresliCtverec(double delkaStrany) {
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }

    public double vypocitejDelkuTretiStrany(double velikostRamene, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((velikostRamene
                * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0))
                * 2.0);
        return tretiStrana;
    }

    public void nakresliTrojuhelnik(double delkaStrany, double uhelVelikost) {
        double tretiStrana = vypocitejDelkuTretiStrany(delkaStrany, uhelVelikost);
        double uhelVelikost2 = (180 + (180 - uhelVelikost) / 2);
        zofka.move(delkaStrany);
        zofka.turnRight(180 - uhelVelikost);
        zofka.move(delkaStrany);
        zofka.turnLeft(uhelVelikost2);
        zofka.move(tretiStrana);
    }

    public void nakresliObdelnik(double stranaA, double stranaB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(stranaA);
            zofka.turnRight(90);
            zofka.move(stranaB);
            zofka.turnRight(90);
        }
    }

    public void nakresliKolecko(double Prumer) {
        double delkaPohybu = ((Prumer * 3.14) / 360);
        for (int i = 0; i < 360; i++) {
            zofka.turnRight(1);
            zofka.move(delkaPohybu);
        }
    }

    public void nakresliZmrzlinu(double delkaStrany, double uhelVelikost) {
        zofka.setLocation(200, 150);
        zofka.turnLeft(180 - (uhelVelikost / 2));
        double delkaTretiStrany = vypocitejDelkuTretiStrany(delkaStrany, uhelVelikost);
        nakresliTrojuhelnik(delkaStrany, uhelVelikost);
        zofka.setLocation(zofka.getX() - delkaTretiStrany / 2, zofka.getY() - delkaTretiStrany / 3 * 2);
        nakresliKolecko(delkaTretiStrany);
    }

    public void nakresliMasinku() {
        zofka.setLocation(200, 300);
        nakresliObdelnik(120, 250);
        zofka.setLocation(200 + 250, 300);
        nakresliObdelnik(220, 160);
        nakresliKolecko(160);
        zofka.setLocation(450 - 220, 300 + 40);
        nakresliKolecko(80);
        zofka.setLocation(340, 340);
        nakresliKolecko(80);
        zofka.setLocation(200, 220);
        zofka.turnRight(180);
        nakresliTrojuhelnik(120, 90);
    }

    public void nakresliSnehulaka() {
        double prumerBricho = vypocitejDelkuTretiStrany(150, 45);
        double prumerHlava = prumerBricho / 2;
        double prumerRuka = prumerHlava / 2;
        double prumerZakladna = prumerBricho * 1.5;

        zofka.setLocation(500 - prumerHlava / 2, 100);
        nakresliKolecko(prumerHlava);
        zofka.setLocation(500 - prumerBricho / 2, 100 + prumerBricho / 2 + prumerHlava / 2);
        nakresliKolecko(prumerBricho);
        zofka.setLocation(500 - prumerZakladna / 2, 100 + prumerZakladna / 2 + prumerBricho + prumerHlava / 2);
        nakresliKolecko(prumerZakladna);

        zofka.setLocation(500 - prumerBricho / 2 - prumerHlava / 2, 100 + prumerBricho / 2 + prumerHlava / 2);
        nakresliKolecko(prumerRuka);
        zofka.setLocation(500 + prumerBricho / 2, 100 + prumerBricho / 2 + prumerHlava / 2);
        nakresliKolecko(prumerRuka);
    }
}
