package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {
    Button btnZero, btnOne,btnTwo,btnThree,btnFour,btnFive,btnSex,btnSeven,btnDelete,btnClear,
    btnEight,btnNine,btnPoint,btnDevide,btnMultipliicate,btnPlus,btnMinus,btnProcent,btnResult, btnSin,
    btnCos, btnTg, btnLog, btnPI, btnStepen, btnE, btnScobLeft, btnScobRight;
    String display = "";
    TextView textView;

    RelativeLayout orienPort,orienLand;

    final String ZNAKI = "/×-+^";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSpecificLayout(this.getResources().getConfiguration().orientation);

        textView = findViewById(R.id.text);
        btnOne = findViewById(R.id.one_port);
        btnTwo = findViewById(R.id.two_port);
        btnThree = findViewById(R.id.three_port);
        btnFour = findViewById(R.id.four_port);
        btnFive = findViewById(R.id.five_port);
        btnSex = findViewById(R.id.six_port);
        btnSeven = findViewById(R.id.seven_port);
        btnEight = findViewById(R.id.eight_port);
        btnNine = findViewById(R.id.nine_port);
        btnDevide = findViewById(R.id.devide_port);
        btnMultipliicate = findViewById(R.id.multiplicate_port);
        btnMinus = findViewById(R.id.minus_port);
        btnPlus = findViewById(R.id.plus_port);
        btnPoint = findViewById(R.id.point_port);
        btnZero = findViewById(R.id.zero_port);
        btnProcent = findViewById(R.id.procent_port);
        btnResult = findViewById(R.id.result_port);
        btnDelete = findViewById(R.id.delete_port);
        btnClear = findViewById(R.id.clear_port);
        btnSin = findViewById(R.id.sin_port);
        btnCos = findViewById(R.id.cos_port);
        btnTg = findViewById(R.id.tg_port);
        btnLog = findViewById(R.id.log_port);
        btnPI = findViewById(R.id.pi_port);
        btnStepen = findViewById(R.id.step_port);
        btnE = findViewById(R.id.E_port);
        btnScobLeft = findViewById(R.id.leftLine_port);
        btnScobRight = findViewById(R.id.rightLine_port);
        orienLand = findViewById(R.id.land);
        orienPort = findViewById(R.id.portrait);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="1";
                textView.setText(display);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="2";
                textView.setText(display);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="3";
                textView.setText(display);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="4";
                textView.setText(display);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="5";
                textView.setText(display);
            }
        });
        btnSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="6";
                textView.setText(display);
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="7";
                textView.setText(display);
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="8";
                textView.setText(display);
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="9";
                textView.setText(display);
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="0";
                textView.setText(display);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ZNAKI.indexOf(display.charAt(display.length() - 1)) != -1) {
                    display = display.substring(0,display.length()-1);

                }
                display+="-";
                textView.setText(display);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ZNAKI.indexOf(display.charAt(display.length() - 1)) != -1) {
                    display = display.substring(0,display.length()-1);

                }
                display+="+";
                textView.setText(display);
            }
        });
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ZNAKI.indexOf(display.charAt(display.length() - 1)) != -1) {
                    display = display.substring(0,display.length()-1);
                }
                display+="/";
                textView.setText(display);
            }
        });
        btnMultipliicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ZNAKI.indexOf(display.charAt(display.length() - 1)) != -1) {
                    display = display.substring(0,display.length()-1);

                }
                display+="×";
                textView.setText(display);
            }
        });
        btnProcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +="%";
                textView.setText(solveExpression(display));
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display +=".";
                textView.setText(display);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!display.isEmpty()) display = display.substring(0,display.length()-1);

                textView.setText(display);

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display = "";
                textView.setText(display);
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(solveExpression(display));
            }
        });
//        btnSin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "sin";
//                textView.setText(display);
//            }
//        });

//        btnCos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "cos";
//                textView.setText(display);
//            }
//        });
//
//        btnTg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "tg";
//                textView.setText(display);
//            }
//        });
//
//        btnLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "log";
//                textView.setText(display);
//            }
//        });
//
//        btnPI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "π";
//                textView.setText(display);
//            }
//        });
//
//        btnStepen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "^";
//                textView.setText(display);
//            }
//        });
//
//        btnE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "E";
//                textView.setText(display);
//            }
//        });
//
//        btnScobLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += "(";
//                textView.setText(display);
//            }
//        });
//
//        btnScobRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                display += ")";
//                textView.setText(display);
//            }
//        });

    };
    public String solveExpression(String display){
       String answer="";
       try {
           answer = String.valueOf(new Expression(
                   display.replace("×","*")
                           .replace("log","log10")
                           .replace("PI","pi")
           ).calculate());
       } catch (Exception e){
           Snackbar.make(orienLand, "Блядская ошибка СУКААААААА!!!. " + e.getMessage(), BaseTransientBottomBar.LENGTH_SHORT).show();
       }
       return answer.replace(".0","");
   }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setSpecificLayout (newConfig.orientation);
    }

    public void setSpecificLayout (int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.layout_land);
        }
        else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }
    }

}

