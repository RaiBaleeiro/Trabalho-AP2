package utils;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import model.Aluno;
import model.IAluno;

public class RepositorioAluno implements IAluno{
    private final String arquivo = "aluno.ser";
    private final String arquivoIdAluno = "idDisciplina.dat";

    @Override
    public List<Aluno> getAllAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try {
            fluxo = new FileInputStream(arquivo);
            while (fluxo.available() > 0) {
                lerObj = new ObjectInputStream(fluxo);
                Aluno a = (Aluno) lerObj.readObject(); 
                alunos.add(a);
            }
            lerObj.close();
        } catch (EOFException e) {
            System.out.println("Erro de fim de arquivo");
        } catch (FileNotFoundException e) {
            System.out.println ("Erro ao listar os alunos");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os alunos");
        }
        return alunos;
    }

    @Override
    public void createAluno(Aluno aluno) {
        FileOutputStream fluxo;
        aluno.setId(controleIdAluno());
        try {
            fluxo = new FileOutputStream(arquivo, true);
            ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo);
            gravarObj.writeObject(aluno);
            gravarObj.close();
        } catch (FileNotFoundException e){
            System.out.println("Erro no cadastro do aluno");
        }
        catch (IOException ex){
            System.out.println ("Erro no cadastro do aluno");
        }
    }

    private int controleIdAluno(){
        File arqId = new File(arquivoIdAluno);
        int id =0;
        try { 
            if (!arqId.exists()){
                arqId.createNewFile();
                atualizaId(id,arqId);
            }
            FileInputStream fis = new FileInputStream (arqId);
            DataInputStream dis = new DataInputStream (fis);
            id = dis.readInt();
            dis.close();
            atualizaId(id,arqId);
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro id disciplina não encontrado");
        } catch (IOException ex) {
            System.out.println ("Erro arquivo idDisciplina");
        }   
        return id;
    }

    private void atualizaId(int id, File arqId) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream (arqId);
        DataOutputStream dos = new DataOutputStream (fos);
        id++;
        dos.writeInt(id);
        dos.close();
    }
}
