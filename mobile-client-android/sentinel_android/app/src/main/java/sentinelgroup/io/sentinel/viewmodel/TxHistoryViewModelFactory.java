package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.TxHistoryRepository;

public class TxHistoryViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final TxHistoryRepository mRepository;

    public TxHistoryViewModelFactory(TxHistoryRepository iRepository) {
        mRepository = iRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new TxHistoryViewModel(mRepository);
    }
}