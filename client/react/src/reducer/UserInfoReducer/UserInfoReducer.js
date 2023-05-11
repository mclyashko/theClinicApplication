import {createAction, createReducer} from "@reduxjs/toolkit";

const initialState = {
    name: '',
    surname: '',
    patronymic: '',
    gender: 'MALE',
    dateOfBirth: '',
    telephone: '',
    login: '',
    password: '',
    role: ''
}

export const updateLoginAction = createAction('UPDATE_LOGIN')

export const updatePasswordAction = createAction('UPDATE_PASSWORD')

export const updateNameAction = createAction('UPDATE_NAME')

export const updateSurnameAction = createAction('UPDATE_SURNAME')

export const updatePatronymicAction = createAction('UPDATE_PATRONYMIC')

export const updateGenderAction = createAction('UPDATE_GENDER')

export const updateDateOfBirthAction = createAction('UPDATE_DATE_OF_BIRTH')

export const updateTelephoneAction = createAction('UPDATE_TELEPHONE')

export const updateRoleAction = createAction('UPDATE_ROLE')

export const clearAction = createAction('CLEAR_USER')

export default createReducer(initialState, {
    [updateLoginAction]: function (state, action) {
        state.login = action.payload
    },
    [updatePasswordAction]: function (state, action) {
        state.password = action.payload
    },
    [updateNameAction]: function (state, action) {
        state.name = action.payload
    },
    [updateSurnameAction]: function (state, action) {
        state.surname = action.payload
    },
    [updatePatronymicAction]: function (state, action) {
        state.patronymic = action.payload
    },
    [updateGenderAction]: function (state, action) {
        state.gender = action.payload
    },
    [updateDateOfBirthAction]: function (state, action) {
        state.dateOfBirth = action.payload
    },
    [updateTelephoneAction]: function (state, action) {
        state.telephone = action.payload
    },
    [updateRoleAction]: function (state, action) {
        state.role = action.payload
    },
    [clearAction]: function (state) {
        state.name = ''
        state.surname = ''
        state.patronymic = ''
        state.gender = ''
        state.dateOfBirth = ''
        state.telephone = ''
        state.login = ''
        state.password = ''
        state.role = ''
    }
})
