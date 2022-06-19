package com.example.demo;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

//import static jdk.nashorn.internal.objects.NativeMath.round;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
        Double simpleInterest = principle*rate*(1.0*days/365);

        return simpleInterest;
    }

    @RequestMapping("table_ui")
    public String home() throws IOException {
        //Reading
        HashMap<String, String> readData = reader.reading();
        System.out.println("Read Data:\t"+readData);

        //System.out.println(readData.get("Account Open Date"));
        Date javaDate= DateUtil.getJavaDate(Double.parseDouble((String) readData.get("Account Open Date")));

        //System.out.println("Hello");
        Double fees= Double.valueOf(readData.get("Finance Fees")),
                principleAmount=Double.valueOf(readData.get("Amount"))+fees,
                rateOfInterest=Double.valueOf(readData.get("Interest Rate"));
        Long installmentsPerYear = Long.valueOf(12), totYears= (Double.valueOf(readData.get("Tenure")).longValue())/12,
                totInstallments;
        Double pmt,lastPMT;
        totInstallments=installmentsPerYear*totYears;
        Double currPrincipal, currInterest, currOpenBal, currClosBal;



        pmt=calculatePmt(principleAmount,rateOfInterest,installmentsPerYear,totYears);
        System.out.println("PMT= "+pmt);

        //Calender works
        //String startDate="10 Jun 22";
        SimpleDateFormat simpleformat2 = new SimpleDateFormat("dd MMM yy");
        String startDate=""+simpleformat2.format(javaDate);
        System.out.println(startDate);
        Calendar cal = Calendar.getInstance();

        Date par = null;
        try {
            par = simpleformat2.parse(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cal.setTime(par);

        //System.out.println("JAVA DATE IS \t"+simpleformat2.format(javaDate));


        xlClass retClass =new xlClass();
        //Create the spreadsheet for emi details
        for (int i=0;i<totInstallments;++i)
        {

            retClass.installmentNumber.addElement(Long.valueOf(i+1));
            retClass.stageNumber.addElement(Long.valueOf(1));
            SimpleDateFormat currSdf=new SimpleDateFormat("dd MMM yy");
            SimpleDateFormat prevSdf=new SimpleDateFormat("dd MMM yy");


            String currDate, prevDate;
            prevDate=prevSdf.format(cal.getTime());
            cal.add(Calendar.MONTH,1);
            currDate=currSdf.format(cal.getTime());
            retClass.installmentDueDate.addElement(currDate);

            retClass.interestRate.addElement(rateOfInterest);
            SimpleDateFormat tempSdf1=new SimpleDateFormat("dd MMM yy");
            SimpleDateFormat tempSdf2=new SimpleDateFormat("dd MMM yy");

            Long day= null;
            try {
                day =(tempSdf2.parse(currDate).getTime()-tempSdf1.parse(prevDate).getTime())/((1000*60*60*24));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if (i==0)
            {
                currOpenBal=principleAmount;
                retClass.installmentAmount.addElement(pmt);
                currInterest=calculatenterest(currOpenBal,rateOfInterest,day);
//            System.out.println(currInterest);
                currPrincipal=pmt-currInterest;
                currClosBal=currOpenBal-currPrincipal;

            }

            else if (i==totInstallments-1)
            {
                currOpenBal=retClass.colCurrClosingBalance.lastElement();

                currInterest=calculatenterest(currOpenBal,rateOfInterest,day);
//            System.out.println(currInterest);
                retClass.installmentAmount.addElement(currOpenBal+currInterest);
                currPrincipal=retClass.installmentAmount.lastElement()-currInterest;
                currClosBal=currOpenBal-currPrincipal;


            }

            else
            {
                retClass.installmentAmount.addElement(pmt);
                currOpenBal=retClass.colCurrClosingBalance.lastElement();
//                System.out.println("i=0     "+currDate+"   "+prevDate+"    "+day);
                currInterest=calculatenterest(currOpenBal,rateOfInterest,day);
//            System.out.println(currInterest);
                currPrincipal=pmt-currInterest;
                currClosBal=currOpenBal-currPrincipal;

            }


            DecimalFormat df=new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.UP);
            retClass.colCurrPrincipal.addElement(currPrincipal);
            retClass.colCurrInterest.addElement(currInterest);
            retClass.colCurrOpeningBalance.addElement(currOpenBal);
            retClass.colCurrClosingBalance.addElement(currClosBal);


        }


        for (int i=0;i<retClass.installmentNumber.size();++i)
        {
            System.out.print(retClass.installmentNumber.elementAt(i)+" ");
            System.out.print(" "+retClass.stageNumber.elementAt(i)+" ");
            System.out.print(" "+retClass.installmentDueDate.elementAt(i)+" ");
            System.out.print(" "+retClass.installmentAmount.elementAt(i)+" ");
            System.out.print(" "+retClass.interestRate.elementAt(i)+" ");
            System.out.print(" "+retClass.colCurrPrincipal.elementAt(i)+" ");
            System.out.print(" "+retClass.colCurrInterest.elementAt(i)+" ");
            System.out.print(" "+retClass.colCurrOpeningBalance.elementAt(i)+" ");
            System.out.print(" "+retClass.colCurrClosingBalance.elementAt(i)+" ");
            System.out.println("");


        }


        Vector<HashMap<String,String>> retVec=new Vector<HashMap<String,String>>();

        return "table_ui.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
