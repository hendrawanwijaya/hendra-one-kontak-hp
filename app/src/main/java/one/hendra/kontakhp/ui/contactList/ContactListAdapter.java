package one.hendra.kontakhp.ui.contactList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import one.hendra.kontakhp.R;
import one.hendra.kontakhp.data.Contact;

public class ContactListAdapter extends ListAdapter<Contact, ContactListAdapter.ContactListViewHolder> {

    private ContactListAdapterListener mListener;

    protected ContactListAdapter() {
        super(new DiffUtil.ItemCallback<Contact>() {
            @Override
            public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
                return oldItem.id==newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
                return oldItem.name.equals(newItem.name)&&oldItem.phoneNumber.equals(newItem.phoneNumber);
            }
        });
    }

    public void setListener(ContactListAdapterListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ContactListViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mPhoneNumber;

        public ContactListViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mPhoneNumber = itemView.findViewById(R.id.phone_number);
        }

        public void bind(final Contact contact){
            mName.setText(contact.name);
            mPhoneNumber.setText(contact.phoneNumber);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        mListener.onClick(contact.id);
                    }
                }
            });
        }
    }

    public interface ContactListAdapterListener{
        void onClick(int contactId);
    }

}
