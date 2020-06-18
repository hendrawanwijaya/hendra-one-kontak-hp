package one.hendra.kontakhp.ui.contactAdd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import one.hendra.kontakhp.R;
import one.hendra.kontakhp.databinding.FragmentContactAddBinding;

public class ContactAddFragment extends Fragment implements ContactAddListener{

    private ContactAddViewModel mViewModel;
    private FragmentContactAddBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_add, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactAddViewModel.class);
        mBinding.setLifecycleOwner(getViewLifecycleOwner());
        mBinding.setViewModel(mViewModel);
        mBinding.setListener(this);
    }

    @Override
    public void onAdd() {
        mViewModel.add();
        NavHostFragment.findNavController(this).navigateUp();
    }
}