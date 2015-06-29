package com.jumlabs.test.hook;

import com.atlassian.stash.hook.*;
import com.atlassian.stash.hook.repository.*;
import com.atlassian.stash.repository.*;
import java.util.Calendar;
import java.util.Collection;

public class BeerOClockHook implements PreReceiveRepositoryHook
{
    /**
     * Disables deletion of branches
     */
    @Override
    public boolean onReceive(RepositoryHookContext context, Collection<RefChange> refChanges, HookResponse hookResponse)
    {
        Calendar now = Calendar.getInstance();
        boolean isFriday = now.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
        boolean isAfter4pm = now.get(Calendar.HOUR_OF_DAY) > 16;
        if(isFriday && isAfter4pm) {
            hookResponse.err().println("Sorry mate, you can't push changes after 4pm on Friday");
            return false;
        }
        return true;        
    }
}
