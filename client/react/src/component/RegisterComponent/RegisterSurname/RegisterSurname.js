import React from 'react'
import './RegisterSurname.css'
import {useDispatch, useSelector} from "react-redux";
import {updateSurnameAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

const RegisterSurname = () => {
    const surname = useSelector(state => state.userInf.surname)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="surname" className="sr-only">Фамилия</label>
            <input value={surname || ''} onChange={event => dispatch(updateSurnameAction(event.target.value))}
                type="text" id="surname" name="surname" className="form-control" placeholder="Фамилия" required="required" autoFocus=""/>
        </div>
    )
}

export default RegisterSurname
