package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

@SpringBootApplication
@Controller
public class DemoApplication {

    public double calculatePmt(double principle, double rate, long installPerYear, long years)
    {
        double PMT;
        double ratePerInstallment=rate/installPerYear;
        long totInstall=installPerYear*years;
        PMT=(principle*ratePerInstallment)/(1-Math.pow((1+ratePerInstallment),(-1*totInstall)));

        return PMT;
    }

    public Double calculatenterest(Double principle, Double rate, Long days)
    {
        Double simpleInterest = principle*rate*(days/365);

        return simpleInterest;
    }

    @RequestMapping("home")
    public String home()
    {
        //System.out.println("Hello");
        Double fees=1000.0,principleAmount=100000+fees, rateOfInterest=0.12;
        Long installmentsPerYear = Long.valueOf(12), totYears= Long.valueOf(2), totInstallments;
        Double pmt,lastPMT;
        totInstallments=installmentsPerYear*totYears;
        Double currPrincipal, currInterest, currOpenBal, currClosBal;
        String startDate="16 Jun 22";


        pmt=calculatePmt(principleAmount,rateOfInterest,installmentsPerYear,totYears);
        System.out.println("PMT= "+pmt);

        //Calender works
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat2 = new SimpleDateFormat("dd MMM yy");
        Date par = null;
        try {
            par = simpleformat2.parse(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cal.setTime(par);
        //String str = simpleformat2.format(cal.getTime());

        xlClass retClass =new xlClass();
        //Create the spreadsheet for emi details
        for (long i=0;i<totInstallments-1;++i)
        {
            retClass.installmentNumber.addElement(i);
            retClass.stageNumber.addElement(i);
            SimpleDateFormat currSdf=new SimpleDateFormat("dd MMM yy");
            SimpleDateFormat prevSdf=new SimpleDateFormat("dd MMM yy");
            String currDate, prevDate;
            prevDate=prevSdf.format(cal.getTime());
            cal.add(Calendar.MONTH,1);
            currDate=currSdf.format(cal.getTime());
            if (i==0)
            {
                retClass.installmentDueDate.addElement(currSdf.format(cal.getTime()));
                retClass.installmentAmount.addElement(pmt);
                retClass.interestRate.addElement(rateOfInterest);
                currOpenBal=principleAmount;
                SimpleDateFormat tempSdf1=new SimpleDateFormat("dd MMM yy");
                SimpleDateFormat tempSdf2=new SimpleDateFormat("dd MMM yy");

                Long day= null;
                try {
                    day = (tempSdf2.parse(currDate).getTime()-tempSdf1.parse(prevDate).getTime())/(1+(1000*60*60*24));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                currInterest=calculatenterest(currOpenBal,rateOfInterest,day);


            }
        }

        return "home.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
