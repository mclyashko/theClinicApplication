import React from 'react';
import './RegisterSubmit.css'
import {useDispatch, useSelector} from "react-redux";
import signUpRequest from "../../../util/request/auth/signUpRequest";
import {loginAction} from "../../../reducer/LoginPageReducer/LoginPageReducer";

function RegisterSubmit(props) {
    const name = useSelector(state => state.userInf.name)
    const surname = useSelector(state => state.userInf.surname)
    const patronymic = useSelector(state => state.userInf.patronymic)
    const gender = useSelector(state => state.userInf.gender)
    const dateOfBirth = useSelector(state => state.userInf.dateOfBirth)
    const phoneNumber = useSelector(state => state.userInf.telephone)
    const email = useSelector(state => state.userInf.login)
    const password = useSelector(state => state.userInf.password)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <button onClick={ async () => {
                const userData = {
                    name: name,
                    surname: surname,
                    patronymic: patronymic,
                    gender: gender,
                    dateOfBirth: dateOfBirth,
                    phoneNumber: phoneNumber,
                    email: email,
                    password: password
                }

                if ((await signUpRequest(JSON.stringify(userData))).ok) {
                    dispatch(loginAction())
                }
            }} type="submit" className="btn btn-secondary btn-block" style={{ width: '100%' }}>
                Регистрация
            </button>
        </div>
    );
}

export default RegisterSubmit;
