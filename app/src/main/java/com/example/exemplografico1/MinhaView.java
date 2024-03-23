package com.example.exemplografico1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.widget.Toast;


class MinhaView extends View {
    private int tipopaint=1;

    public MinhaView(Context cx) {
        super(cx);
        final Context viewContext = cx;

        setOnLongClickListener (new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(viewContext,
                        "\n\nVamos limpar a tela, sem pintar nada.\n\n", Toast.LENGTH_LONG).show();
                setTipoPaint(2);
                return true;
            }
        });
    }

    public void setTipoPaint(int i) {
        tipopaint = i;
        invalidate();
    }
    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setAntiAlias(true); //para suavizar as bordas (não o interior) do que será pintado
        switch (tipopaint) {
            case 1:
                //Pintamos uma figura em forma de retângulo
                ShapeDrawable fig1 = new ShapeDrawable(new RectShape());
                fig1.getPaint().setColor(0xFFFFFF00); //retângulo amarelo
                //Obs.: setBounds(int left, int top, int right, int bottom)
                //setColor: os primeiros dois números são o componente
                //alpha (a opacidade). FF será 100% opaco. Resumindo: 0xAARRGGBB
                fig1.setBounds(0,0,95,120);
                fig1.draw(c);

                p.setColor(0xFFCCCCCC); //retângulo cinza claro
                c.drawRect(35,75,c.getWidth()-30, c.getHeight()-110,p);

                p.setColor(0xFF0000FF); //círculo azul
                c.drawCircle(c.getWidth()/2, c.getHeight()/2, c.getHeight()/4, p);

                p.setColor(0xFF00FF00); //círculo verde
                c.drawCircle(c.getWidth()/2, c.getHeight()/2, c.getHeight()/8, p);

                p.setColor(0xFF000000); //linha preta
                p.setStrokeWidth(20); //largura da linha
                c.drawLine(0,0,c.getWidth()/2, c.getHeight()/2,p);

                //Pintamos uma figura em forma de oval
                OvalShape ov;
                ov = new OvalShape();
                ShapeDrawable fig2 = new ShapeDrawable(ov);
                //Ou resumindo seria: ShapeDrawable fig2 = new ShapeDrawable(new OvalShape());
                fig2.getPaint().setColor(0x88FF0000); //certa transparência com 88
                fig2.setBounds(10,10,getWidth()/2,getHeight()/2 + 20);
                //getWidth() e getHeight() são valores relativos à área da View gráfica
                fig2.draw(c);

                p.setColor(0xFF000000); //para textos pretos
                p.setTextSize(50);
                c.drawText("Observe a transparência do oval vermelho.", 2, getHeight()-67, p);
                c.drawText("Experimente touch e touch longo na tela.", 2, getHeight()-13, p);
                break;

            case 2:
                p.setTextSize(50);
                c.drawText("Experimente agora touch simples na tela.", 2, getHeight()-13, p);
                break;  //não pintamos nada neste caso
        }//switch
    }//método onDraw

}//classe MinhaView
