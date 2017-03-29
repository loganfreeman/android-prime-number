package education.loganfreeman.com.primenumber.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import education.loganfreeman.com.primenumber.R;
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


    @BindView(R.id.show_factor)
    Button showFactorBtn;


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

        leftOperand.setText(getInt(10, 1000) + "");

        rightOperand.setText(getInt(10, 1000) + "");

        return view;


    }
    @OnClick(R.id.show_factor)
    void onShowFactorClick(View view) {

    }

    @OnClick(R.id.show_next)
    void onShowNextClick(View view) {
        leftOperand.setText(getInt(10, 1000) + "");

        rightOperand.setText(getInt(10, 1000) + "");
    }

    @OnTextChanged(R.id.left_operand)
    void onLeftOperandChange(Editable editable) {

    }

    @OnTextChanged(R.id.right_operand)
    void onRightOperandChange(Editable editable) {

    }
}

