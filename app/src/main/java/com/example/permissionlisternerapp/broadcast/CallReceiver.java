package com.example.permissionlisternerapp.broadcast;

import android.content.Context;
import android.util.Log;

import com.example.permissionlisternerapp.ApplicationJ;
import com.example.permissionlisternerapp.database.entity.CallListEntity;

import java.util.Date;

public class CallReceiver extends PhoneCallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Log.e("*+*+*","onIncomingCallStarted ctx : "+ctx+" :: number : "+number+" :: start : "+start);
        CallListEntity callListEntity = new CallListEntity();
        callListEntity.setState("Incoming start");
        callListEntity.setNumber(""+number);
        callListEntity.setStartTime(""+start);
        callListEntity.setEndTime("");
        ApplicationJ.db.callListDao().insertCallList(callListEntity);
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        Log.e("*+*+*","onOutgoingCallStarted ctx : "+ctx+" :: number : "+number+" :: start : "+start);
        CallListEntity callListEntity = new CallListEntity();
        callListEntity.setState("Outgoing start");
        callListEntity.setNumber(""+number);
        callListEntity.setStartTime(""+start);
        callListEntity.setEndTime("");
        ApplicationJ.db.callListDao().insertCallList(callListEntity);
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.e("*+*+*","onIncomingCallEnded ctx : "+ctx+" :: number : "+number+" :: end : "+end);
        CallListEntity callListEntity = new CallListEntity();
        callListEntity.setState("Incoming end");
        callListEntity.setNumber(""+number);
        callListEntity.setStartTime(""+start);
        callListEntity.setEndTime(""+end);
        ApplicationJ.db.callListDao().insertCallList(callListEntity);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.e("*+*+*","onOutgoingCallEnded ctx : "+ctx+" :: number : "+number+" :: end : "+end);
        CallListEntity callListEntity = new CallListEntity();
        callListEntity.setState("Outgoing end");
        callListEntity.setNumber(""+number);
        callListEntity.setStartTime(""+start);
        callListEntity.setEndTime(""+end);
        ApplicationJ.db.callListDao().insertCallList(callListEntity);
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        Log.e("*+*+*","onMissedCall ctx : "+ctx+" :: number : "+number+" :: start : "+start);
        CallListEntity callListEntity = new CallListEntity();
        callListEntity.setState("Missedcall");
        callListEntity.setNumber(""+number);
        callListEntity.setStartTime(""+start);
        callListEntity.setEndTime("");
        ApplicationJ.db.callListDao().insertCallList(callListEntity);
    }

}
