/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatascelulares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Invited
 */
public class Regla {
    
    int[] vec_binario=new int[8];
    int numero ;
    Lapiz lap=new Lapiz();
    private Archivo objArchivo;
    
    public void getBinario(int numero){
        this.vec_binario=this.binario(numero);
    }
    
    public int[] binario(int numero){
        int vec_Binario[] = new int[8];
        for(int i =7;i>=0;i--){
            vec_Binario[i]=numero%2;
            //System.out.println("elemento "+binario[i]);
            numero/=2;
        }
        return vec_Binario;
    }
    int r=0;
    public int getCasillas(int A,int B, int C){
        
            this.getBinario(numero);
        
          
        
            if(A==0 && B==0 && C==0){r=vec_binario[7];
            //System.out.println("r 1= "+ r);
            }else if(A==0 && B==0 && C==1){r=vec_binario[6];
            //System.out.println("r 2= "+ r);
            }else if(A==0 && B==1 && C==0){r=vec_binario[5];
            //System.out.println("r 3= "+ r);
            }else if(A==0 && B==1 && C==1){r=vec_binario[4];
            //System.out.println("r 4= "+ r);
            }else if(A==1 && B==0 && C==0){r=vec_binario[3];
            //System.out.println("r 5= "+ r);
            }else if(A==1 && B==0 && C==1){r=vec_binario[2];
            //System.out.println("r 6= "+ r);
            }else if(A==1 && B==1 && C==0){r=vec_binario[1];
            //System.out.println("r 7= "+ r);
            }else if(A==1 && B==1 && C==1){r=vec_binario[0];
            //System.out.println("r 8= "+ r);
            }
        return r;
    }
    
    public void simulacion(int n){
       
        int A,B,C;
        int[] lapiz=new int[n];
        lapiz=lap.getLapiz(n);
        System.out.println(Arrays.toString(lapiz));
        for(int j=0;j<lapiz.length;j++){
            
            int aux[]=new int[lapiz.length];
            for (int i = 0;i<lapiz.length;i++){


                if(i==0){
                    A=lapiz[lapiz.length-1];
                    //System.out.println("A--"+A);
                    B=lapiz[i];
                    //System.out.println("B--"+B);
                    C=lapiz[i+1];
                    //System.out.println("C--"+C);
                }else if(i==lapiz.length-1){
                    A=lapiz[i-1];
                    B=lapiz[i];
                    C=lapiz[0];
                }else{
                    A=lapiz[i-1];
                    //System.out.println("A--"+A);
                    B=lapiz[i];
                    //System.out.println("B--"+B);
                    C=lapiz[i+1];
                    //System.out.println("C--"+C);
                }


                r=this.getCasillas(A, B, C);
                //System.out.println("________________________________________");
                aux[i]=r;
            }
            
            System.out.println(Arrays.toString(aux));

            lapiz=aux;
            //System.out.println(Arrays.toString(lapiz));
        }
    }
}

