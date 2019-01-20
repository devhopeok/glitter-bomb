package develop.com.glitterbomb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Toast;

public class MediaButtonIntentReceiver extends BroadcastReceiver {

    public MediaButtonIntentReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            return;
        }
        KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            return;
        }

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
        }
        abortBroadcast();
    }
}
