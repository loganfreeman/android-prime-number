package education.loganfreeman.com.primenumber.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import education.loganfreeman.com.primenumber.R;
import education.loganfreeman.com.primenumber.utils.MathUtil;
import education.loganfreeman.com.primenumber.utils.ToastUtil;

import static android.R.attr.max;

/**
 * Created by shanhong on 3/29/17.
 */

public class MathFragment extends Fragment {

    private View view;


    @BindView(R.id.right_operand_result)
    TextView rightOperand;


    @BindView(R.id.left_operand_result)
    TextView leftOperand;

    @BindView(R.id.right_operand)
    EditText rightOperandEdit;


    @BindView(R.id.left_operand)
    EditText leftOperandEdit;


    @BindView(R.id.show_factor)
    Button showFactorBtn;

    @BindView(R.id.show_next)
    Button showNextBtn;

    @BindView(R.id.show_result)
    Button showResultBtn;

    int left_operand;

    int right_operand;

    int commonFactor;

    @BindView(R.id.left_operand_factors)
    GridLayout leftContainer;

    @BindView(R.id.right_operand_factors)
    GridLayout rightContainer;

    @BindView(R.id.common_factors)
    GridLayout commonContainer;




    public MathFragment() {
        // Required empty public constructor
    }

    int getInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_prime_number, container, false);

        ButterKnife.bind(this, view);

        onShowNextClick(showNextBtn);

        return view;


    }

    @OnClick(R.id.show_result)
    void onShowResult(View view) {
        List<Integer> left_factors = MathUtil.primeFactors(left_operand);
        List<Integer> right_factors = MathUtil.primeFactors(right_operand);


        List<Integer> common = new ArrayList<Integer>();

        for(Integer i : right_factors) {
            if(left_factors.contains(i)) {
                left_factors.remove(i);
                common.add(i);
            }
        }

        int commonFactor = common.stream().reduce(1, (a, b) -> a*b);

        leftOperandEdit.setText(left_operand/commonFactor + "");
        rightOperandEdit.setText(right_operand/commonFactor + "");


    }
    @OnClick(R.id.show_factor)
    void onShowFactorClick(View view) {

        // ToastUtil.showShort(String.format("show primer factors: %d / %d", left_operand, right_operand));

        leftContainer.removeAllViews();

        rightContainer.removeAllViews();

        commonContainer.removeAllViews();


        List<Integer> left_factors = MathUtil.primeFactors(left_operand);

        List<Integer> common = new ArrayList<Integer>();

        for(Integer i : left_factors) {
            Button textView = new Button(getActivity());
            textView.setText(i + "");
            leftContainer.addView(textView, new GridLayout.LayoutParams());

        }



        List<Integer> right_factors = MathUtil.primeFactors(right_operand);


        for(Integer i : right_factors) {
            Button textView = new Button(getActivity());
            textView.setText(i + "");
            rightContainer.addView(textView, new GridLayout.LayoutParams());

            if(left_factors.contains(i)) {
                left_factors.remove(i);
                common.add(i);
            }




        }



        for(Integer i : common) {
            Button textView = new Button(getActivity());
            textView.setText(i + "");
            commonContainer.addView(textView, new GridLayout.LayoutParams());

        }
    }

    @OnClick(R.id.show_next)
    void onShowNextClick(View view) {
        left_operand = getInt(10, 1000);
        right_operand = getInt(10, 1000);
        leftOperand.setText(left_operand + "");

        rightOperand.setText(right_operand + "");

        leftContainer.removeAllViews();

        rightContainer.removeAllViews();

        commonContainer.removeAllViews();

        leftOperandEdit.setText("");
        rightOperandEdit.setText("");
    }


}

