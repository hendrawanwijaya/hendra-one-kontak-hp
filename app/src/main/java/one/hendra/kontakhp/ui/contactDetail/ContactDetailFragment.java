package one.hendra.kontakhp.ui.contactDetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import one.hendra.kontakhp.R;
import one.hendra.kontakhp.databinding.FragmentContactDetailBinding;

public class ContactDetailFragment extends Fragment implements ContactDetailListener{

    private ContactDetailViewModel mViewModel;
    private FragmentContactDetailBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_detail, container, false);
        setHasOptionsMenu(true);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ContactDetailViewModelFactory factory = new ContactDetailViewModelFactory(getActivity().getApplication(), getArguments().getInt("contactId"));
        mViewModel = new ViewModelProvider(this, factory).get(ContactDetailViewModel.class);
        mBinding.setLifecycleOwner(getViewLifecycleOwner());
        mBinding.setViewModel(mViewModel);
        mBinding.setListener(this);
    }

    @Override
    public void onSave() {
        mViewModel.save();
        NavHostFragment.findNavController(this).navigateUp();
    }

    @Override
    public void onDelete() {
        mViewModel.delete();
        NavHostFragment.findNavController(this).navigateUp();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_contact_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.delete){
            onDelete();
        }
        return super.onOptionsItemSelected(item);
    }
}