import React from 'react';
import './RegisterPatronymic.css'
import {useDispatch, useSelector} from "react-redux";
import {updatePatronymicAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

function RegisterPatronymic() {
    const patronymic = useSelector(state => state.userInf.patronymic)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="patronymic" className="sr-only">Отчество</label>
            <input value={patronymic || ''} onChange={event => dispatch(updatePatronymicAction(event.target.value))}
                type="text" id="patronymic" name="patronymic" className="form-control" placeholder="Отчество" required="required" autoFocus=""/>
        </div>
    );
}

export default RegisterPatronymic;
