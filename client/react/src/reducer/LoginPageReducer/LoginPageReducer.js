import {createAction, createReducer} from "@reduxjs/toolkit";

const initialState = {
    loginPage: true
}

export const loginAction = createAction('LOGIN')
export const registerAction = createAction('REGISTER')

export default createReducer(initialState, {
    [loginAction]: function (state) {
        state.loginPage = true
    },
    [registerAction]: function (state) {
        state.loginPage = false
    }
})
