package com.bignerdranch.android.fabricshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

import static android.widget.CompoundButton.*;

public class FabricFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Fabric mFabric;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;
    private SeekBar mSeekFabric;
    private EditText mFabricCostInput;
    private TextView mFabricCostPerM;

    public static FabricFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        FabricFragment fragment = new FabricFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mFabric = FabricLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fabric, container, false);
//
        mFabricCostPerM = (TextView) v.findViewById(R.id.fabric_cost_per_m);
        mSeekFabric = (SeekBar) v.findViewById(R.id.seekFabric);
        final TextView seekBarValue = (TextView) v.findViewById(R.id.howLong);
        mSeekFabric.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                seekBarValue.setText(String.valueOf(progress) + "CM");
                double value = 0.0;
                try {
                    value = Double.parseDouble(mFabricCostInput.getText().toString());
                } catch (NumberFormatException e) {
                    value = 0.0;
                }
                mFabricCostPerM.setText(String.valueOf(mSeekFabric.getProgress() * value));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mFabricCostInput = (EditText) v.findViewById(R.id.fabric_cost);

//        mFabricCostInput.setText((int) mFabric.getFabricCost());
        mFabricCostInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double value = 0.0;
                try {
                    value = Double.parseDouble(s.toString());
                } catch (NumberFormatException e) {
                    value = 0.0;
                }

                mFabricCostPerM.setText(String.valueOf(mSeekFabric.getProgress() * value));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mDateButton = (Button) v.findViewById(R.id.crime_date);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mFabric.getDate());
                dialog.setTargetFragment(FabricFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckbox.setChecked(mFabric.isSolved());
        mSolvedCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mFabric.setSolved(isChecked);
            }
        });


        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mFabric.setDate(date);
            updateDate();
        }
    }

    private void updateDate() {
        mDateButton.setText(mFabric.getDate().toString());
    }
}
