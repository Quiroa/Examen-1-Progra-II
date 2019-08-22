/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugit;

import java.applet.Applet;
import java.awt.Graphics;
import javax.swing.JOptionPane;
public class NGit extends Applet {//Inicia la clase "NGit"
    int[] ca=new int [4];//Carnet de los 4 alumnos
    int[] no=new int [4];//Nota de los 4 alumnos
    int aux,i,y;/*aux: variable auxiliar
                  i: Variable de conteo
                  y: variable de posicion
                */
    boolean c,cc=false;//Variables centinelas
    String tmp;//Varialbe temporal para el ingreso de datos
    public void init(Graphics g) {//Metodo principal de la clase "Notas"
        for (i=0;i<4;i++){//Contador desde 0 hasta 4
            tmp=JOptionPane.showInputDialog("Ingrese el carnet "+(i+1)+"/4");//Ingreso del carnet del alumno
            ca[i]=Integer.parseInt(tmp);//Asignacion del carnet del alumno a una varialbe tipo entero
            tmp=JOptionPane.showInputDialog("Ingrese la nota "+(i+1)+"/4");//Ingrso de la nota del alumno
            no[i]=Integer.parseInt(tmp);//Asignacion de la nota del alumno a una varialbe tipo entero
        }//Finaliza el contador
        do{//Ciclo condicional para el ordenamiento de datos
            c=true;//Inicializacion del centinela "c" en true (verdadero)
            for (i=0;i<3;i++){//Contador desde 0 asta 3
                if (no[i]<no[i+1]){//Condicional que verifica que el dato "a" sea menor que el dato "b"
                    aux=ca[i];//Almacenamiento en variable auxciliar del dato a
                    ca[i]=ca[i+1];//Asignacion de la nueva posicion del dato "b"
                    ca[i+1]=aux;//Asignacion de la nueva posicion del dato "a"
                    aux=no[i];//Almacenamiento en variable auxiliar del dato a
                    no[i]=no[i+1];//Asignacion de la nueva posicion del dato "b"
                    no[i+1]=aux;//Asignacion de la nueva poscion del dato "a"
                    c=false;//Reasignacion de la variable centinela "c" a false (falso)
                }//Finaliza el condicional
            }//Finaliza el contador
        }while(!c);//Finalizara el siclo condicional asta que la variable centinela "c" llegue al final del proseso con valor true (verdadero)
        paint(g);//Llamado a la funcion "paint"
    }//Finaliza la funcion "init"
    public void paint(Graphics g){//Funcion que muestra el nuevo orden de los datos ingresados
        //      ¡IMPORTANTE: NO REMOVER ESTE "IF"!
        if (!cc){//Solucion a un bug generado por el parametro "Graphics g" en la funcion "init"
            cc=true;//Asignacion del centinela "cc" en true
            init (g);//Llamado a la funcion "init"
        }//Finaliza el "if" (condicional) previamente mencionado
        g.drawString("Carnet",20,20);//Titulo "Carnet"
        g.drawString("Nota",100,20);//Titulo "Notas"
        y=45;//inicializacion de la variable de posicion "y"
        for (i=0;i<4;i++){//Contador desde 0 asta 3
            g.drawString(""+ca[i], 35,y);//Dato: carnet del estudiante #
            g.drawString(""+no[i], 110,y);//Dato: nota del estudiante #
            y+=20;//Desplazamiento en el eje y para los proximos datos
        }//Finaliza el contador
    }//Finaliza la funcion "paint"
}//Finaliza la clase "NGit"
