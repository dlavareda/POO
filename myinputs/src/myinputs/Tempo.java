/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinputs;

/**
 *
 * @author dlavareda
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tempo {

    private static String[] saudacoes = {"Bom dia", "Boa tarde", "Boa noite"};
    private static String nome = "Diogo";
    private static String[] nomemes = {"NULL", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static int horas;
    private static int minutos;
    private static int segundos;
    private static int dia;
    private static int mes;
    private static int ano;
    private static int diasemana;

    public static void getHoras() {
        LocalDateTime dataComputador = LocalDateTime.now();
        horas = dataComputador.getHour();
        minutos = dataComputador.getMinute();
        segundos = dataComputador.getSecond();
        dia = dataComputador.getDayOfMonth();
        mes = dataComputador.getMonthValue();
        ano = dataComputador.getYear();
        diasemana = (dataComputador.getDayOfWeek()).getValue();
    }

    private static int periodoDia(int h) {
        return (h + 20) / 8 % 3;
    }

    public static void main(String args[]) {
        getHoras();
        System.out.println(saudacoes[periodoDia(horas)] + ", " + nome);

        String msg1 = minutos == 0 ? horas + " em ponto" : horas + " hora" + (horas == 1 ? "" : "s");
        String msg2 = " e " + minutos + " minuto" + (minutos != 1 ? "s" : "");
        System.out.println(msg1 + (minutos == 0 ? "" : msg2));
        System.out.println("\n");

        if (minutos == 1) {
            if (horas == 1) {
                System.out.println(horas + " hora, " + minutos + " minuto!");
                System.out.println("Passa " + minutos + " minuto da " + horas + " hora.");
                System.out.println("Faltam " + (60 - minutos) + " minutos para a " + (horas + 1) + " hora.");
            } else {
                System.out.println(horas + " horas, " + minutos + " minuto!");
                System.out.println("Passa " + minutos + " minuto das " + horas + " horas.");
                System.out.println("Faltam " + (60 - minutos) + " minutos para as " + (horas + 1) + " horas.");
            }
        } else if (minutos == 0) {
            if (horas == 1) {
                System.out.println(horas + " hora em ponto");
            } else {
                System.out.println(horas + " horasem ponto");
            }
        } else {
            if (horas == 1) {
                System.out.println(horas + " hora, " + minutos + " minutos!");
                System.out.println("Passam " + minutos + " minutos da " + horas + " hora.");
                System.out.println("Faltam " + (60 - minutos) + " minutos para as " + (horas + 1) + " hora.");
            } else {
                System.out.println(horas + " horas, " + minutos + " minutos!");
                System.out.println("Passam " + minutos + " minutos das " + horas + " horas.");
                System.out.println("Faltam " + (60 - minutos) + " minutos para as " + (horas + 1) + " horas.");
            }
        }

        System.out.println("\n");
        System.out.println("\n");
        System.out.println(horas + ":" + minutos + ":" + segundos);
        System.out.println(dia + "/" + mes + "/" + ano);
        System.out.println(dia + " de " + nomemes[mes] + " de " + ano);

        System.out.println("Faltam " + (5 - diasemana) + " dia para o fim se semana");

        LocalDate dt = LocalDate.now();
        int count = 0;
        while (count < 13) {
            dt = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

            if (dt.getDayOfMonth() == 13) {
                System.out.println("\nSexta-Feira 13: " + dt);
                count++;
            }
        }

    }
}


/*
*i) Apresente as horas de um modo gramaticalmente correto (1 hora, 1 minuto! Passam, faltam! Horas
exactas?)
*ii) Refaça o exercício anterior usando o operador ternário.
*iii) Apresente também a data.
*iv) Refaça o exercício anterior mostrando o mês por extenso.
v) Indique o número de dias que faltam até ao fim-de-semana...
vi) Apresente a listagem das datas das 13 próximas Sextas-feiras 13.
 */
