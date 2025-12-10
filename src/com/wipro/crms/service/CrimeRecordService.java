package com.wipro.crms.service;

import com.wipro.crms.entity.*;
import com.wipro.crms.util.*;

import java.util.ArrayList;

public class CrimeRecordService {

    private ArrayList<CrimeCase> cases;
    private ArrayList<Suspect> suspects;
    private ArrayList<InvestigationUpdate> updates;

    public CrimeRecordService() {
        cases = new ArrayList<>();
        suspects = new ArrayList<>();
        updates = new ArrayList<>();
    }

    public void addCrimeCase(CrimeCase crime) {
        cases.add(crime);
    }

    public CrimeCase findCrimeCase(String caseId) throws CaseNotFoundException {
        for (CrimeCase c : cases) {
            if (c.getCaseID().equals(caseId)) return c;
        }
        throw new CaseNotFoundException("Case not found");
    }

    public void addSuspectToCase(String caseId, Suspect s) throws Exception {
        CrimeCase cc = findCrimeCase(caseId);

        cc.addSuspect(s.getSuspectId());
        suspects.add(s);
    }

    public void addUpdate(InvestigationUpdate u) throws Exception {
        CrimeCase cc = findCrimeCase(u.getCaseId());
        cc.addUpdate(u.getUpdateId());
        updates.add(u);
    }

    public ArrayList<Suspect> getCaseSuspects(String caseId) throws CaseNotFoundException {
        CrimeCase cc = findCrimeCase(caseId);
        ArrayList<Suspect> result = new ArrayList<>();

        for (String id : cc.getSuspetIds()) {
            for (Suspect s : suspects) {
                if (s.getSuspectId().equals(id)) result.add(s);
            }
        }
        return result;
    }

    public ArrayList<InvestigationUpdate> getCaseUpdates(String caseId) throws CaseNotFoundException {
        CrimeCase cc = findCrimeCase(caseId);
        ArrayList<InvestigationUpdate> result = new ArrayList<>();

        for (String id : cc.getUpdateIds()) {
            for (InvestigationUpdate u : updates) {
                if (u.getUpdateId().equals(id)) result.add(u);
            }
        }
        return result;
    }
}
