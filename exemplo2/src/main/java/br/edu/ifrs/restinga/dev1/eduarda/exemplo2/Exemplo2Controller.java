package br.edu.ifrs.restinga.dev1.eduarda.exemplo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


@Controller
public class Exemplo2Controller {

    @RequestMapping("/oi/{nome}")
    @ResponseBody
    public String oi (@PathVariable String nome){
        return "Oi, "+nome+"!";
    }

   @RequestMapping("/oi2/{nome}")
   @ResponseBody
   public String oi_dois (@PathVariable String nome, @RequestParam("horas") int horas){
        if (horas > 18)
           return "Boa noite, "+nome+"!";
        else if (horas > 12)
           return "Boa tarde, "+nome+"!";
        else
           return "Boa dia, "+nome+"!";
   }

   @RequestMapping("/imc/{peso}/{altura:.+}")
   @ResponseBody
   public String imc (@PathVariable double peso, @PathVariable double altura){
        double imcc = 0.0; 

        imcc = peso/(altura*altura); 

        if (imcc < 18.5) {            
            return "Você está mais magro que o normal e seu imc é: "+imcc+"!";
        }
        else if ((imcc > 18.5) & (imcc < 24.9)) {            
            return "Você está com o imc normal e seu imc é: "+imcc+"!";
        }
        else if ((imcc > 25) & (imcc < 29.9)) {            
            return "Você tem sobrepeso e seu imc é: "+imcc+"!";
        }
        else if ((imcc > 30) & (imcc < 34.9)) {            
            return "Você tem obesidade Grau I e seu imc é: "+imcc+"!";
        }
        else if ((imcc > 35) & (imcc < 39.9)) {            
            return "Você tem obesidade Grau II (severa) e seu imc é: "+imcc+"!";
        }
        else {            
            return "Você tem obesidade Grau III (mórbida) e seu imc é: "+imcc+"!";
        }
   }

   @RequestMapping("/diaSemana/{ano}/{mês}/{dia}")
   @ResponseBody
   public String diaSemana (@PathVariable int ano, @PathVariable int mês, @PathVariable int dia){
        return getDayOfWeek(""+dia+"/"+mês+"/"+ano+""); 
   }

        
   public static String getDayOfWeek(String data) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("d/M/uuuu"); 
            //não pude usar dd/MM então usei apenas d/M, pois não funcionava quando a data tinha zeros a esquerda. Ex: 09/09/2021 gerava um parser erro
        DayOfWeek dow = DayOfWeek.from(parser.parse(data));
        return dow.getDisplayName(TextStyle.FULL, new Locale("pt", "BR")).toUpperCase();            
    }

    
   @RequestMapping("/calculadora/adicao")
   @ResponseBody
   public String calculadoraAdicao (@RequestParam double n1, @RequestParam double n2){    
        double resultado = n1+n2;
        return ("O resultado da soma é: " +String.valueOf(resultado)); 
   }

   @RequestMapping("/calculadora/subtracao")
   @ResponseBody
   public String calculadoraSubtracao (@RequestParam double n1, @RequestParam double n2){
        double resultado = n1-n2;
        return ("O resultado da subtracao é: " +String.valueOf(resultado)); 
   }

   @RequestMapping("/calculadora/multiplicacao")
   @ResponseBody
   public String calculadoraMultiplicacao (@RequestParam double n1, @RequestParam double n2){
        double resultado = n1*n2;
        return ("O resultado da multiplicacao é: " +String.valueOf(resultado)); 
   }

   @RequestMapping("/calculadora/divisao")
   @ResponseBody
   public String calculadoraDivisao( @RequestParam double n1, @RequestParam double n2){
        double resultado = n1/n2;
        return ("O resultado da soma é: " +String.valueOf(resultado)); 
   }

}