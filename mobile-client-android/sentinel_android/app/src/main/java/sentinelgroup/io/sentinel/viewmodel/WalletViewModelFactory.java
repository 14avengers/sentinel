package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.WalletRepository;

public class WalletViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final WalletRepository mRepository;

    public WalletViewModelFactory(WalletRepository iRepository) {
        mRepository = iRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new WalletViewModel(mRepository);
    }
}
