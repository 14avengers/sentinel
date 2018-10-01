package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.VpnRepository;

public class RatingViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final VpnRepository mVpnRepository;

    public RatingViewModelFactory(VpnRepository iVpnRepository) {
        mVpnRepository = iVpnRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new RatingViewModel(mVpnRepository);
    }
}
