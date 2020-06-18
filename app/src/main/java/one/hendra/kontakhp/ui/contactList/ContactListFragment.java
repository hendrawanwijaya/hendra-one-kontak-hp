package one.hendra.kontakhp.ui.contactList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import one.hendra.kontakhp.R;
import one.hendra.kontakhp.data.Contact;

public class ContactListFragment extends Fragment implements ContactListAdapter.ContactListAdapterListener {

    private ContactListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mAdapter = new ContactListAdapter();
        mAdapter.setListener(this);
        recyclerView.setAdapter(mAdapter);
        ContactListViewModel viewModel = new ViewModelProvider(this).get(ContactListViewModel.class);
        viewModel.contacts.observe(getViewLifecycleOwner(), new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                mAdapter.submitList(contacts);
            }
        });
    }

    @Override
    public void onClick(int contactId) {
        Bundle bundle = new Bundle();
        bundle.putInt("contactId", contactId);
        NavHostFragment.findNavController(this).navigate(R.id.action_contactListFragment_to_contactDetailFragment, bundle);
    }
}