package br.edu.ifrs.restinga.dev1.eduarda.exemplo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Livro {
    private int id;
    private String titulo;
    private String autorPrimeiroNome;
    private String autorSegundoNome;
    private String anoPublicacao;
    private String editor;
    private boolean doacao;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutorPrimeiroNome() {
        return autorPrimeiroNome;
    }

    public void setAutorPrimeiroNome(String autorPrimeiroNome){
        this.autorPrimeiroNome = autorPrimeiroNome;
    }

    public String getAutorSegundoNome() {
        return autorSegundoNome;
    }

    public void setAutorSegundoNome(String autorSegundoNome){
        this.autorSegundoNome = autorSegundoNome;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor){
        this.editor = editor;
    }

    public boolean getDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao){
        this.doacao = doacao;
    }
}