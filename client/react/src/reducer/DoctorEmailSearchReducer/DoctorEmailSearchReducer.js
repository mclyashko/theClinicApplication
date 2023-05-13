import React from 'react';
import {createAction, createReducer} from "@reduxjs/toolkit";

const initialState = {
    emailPattern: '',
    records: [],
    verdicts: {}
}

export const updateEmailPatternAction = createAction('UPDATE_EMAIL_PATTERN')
export const updateFoundByEmailRecordListAction = createAction('UPDATE_FOUND_BY_EMAIL_RECORD_LIST')
export const updateVerdictByRecordIdAction = createAction('UPDATE_VERDICT_BY_RECORD_ID')

export default createReducer(initialState, {
    [updateEmailPatternAction]: function (state, action) {
        state.emailPattern = action.payload
    },
    [updateFoundByEmailRecordListAction]: function (state, action) {
        state.records = action.payload
    },
    [updateVerdictByRecordIdAction]: function (state, action) {
        state.verdicts[action.payload.id] = action.payload.value
    }
});
