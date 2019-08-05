/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatascelulares;

/**
 *
 * @author Invited
 */
public class Lapiz {
    
    public int[] getLapiz(int tamaño){
        
        if((tamaño % 2) == 0){
            int[] vec_Lapiz=new int[tamaño+1];
            for(int i=0;i<tamaño;i++){
                vec_Lapiz[i]=0;
            } 
            vec_Lapiz[(tamaño/2)]=1;
            return vec_Lapiz;
        }else{
            int[] vec_Lapiz=new int[tamaño];
            for(int i=0;i<tamaño;i++){
                vec_Lapiz[i]=0;
            } 
            vec_Lapiz[(tamaño/2)]=1;
            return vec_Lapiz;
        }  
    }
    
}
