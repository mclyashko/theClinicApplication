import React from 'react';
import './LoginSubmit.css'
import {useDispatch, useSelector} from "react-redux";
import signInRequest from "../../../util/request/auth/signInRequest";
import currentUserRequest from "../../../util/request/auth/currentUserRequest";
import {
    updateDateOfBirthAction,
    updateGenderAction, updateIdAction, updateLoginAction,
    updateNameAction,
    updatePatronymicAction,
    updateRoleAction,
    updateSurnameAction,
    updateTelephoneAction
} from "../../../reducer/UserInfoReducer/UserInfoReducer";

const LoginSubmit = () => {
    const login = useSelector(state => state.userInf.login)
    const password = useSelector(state => state.userInf.password)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <button type="submit" className="btn btn-secondary btn-block" style={{ width: '100%' }}
                onClick={ async () => {
                    const signInData = await signInRequest(login, password)
                    const currentUser = await currentUserRequest()
                    await currentUser
                    console.log(signInData.role)
                    dispatch(updateRoleAction(signInData.role))
                    dispatch(updateIdAction(currentUser.id))
                    dispatch(updateNameAction(currentUser.name))
                    dispatch(updateSurnameAction(currentUser.surname))
                    dispatch(updatePatronymicAction(currentUser.patronymic))
                    dispatch(updateGenderAction(currentUser.gender))
                    dispatch(updateDateOfBirthAction(currentUser.dateOfBirth))
                    dispatch(updateTelephoneAction(currentUser.phoneNumber))
                }}
            >
                Вход
            </button>
        </div>
    )
}

export default LoginSubmit
