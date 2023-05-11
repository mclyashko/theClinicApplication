import React from 'react';
import './RegisterPhoneNumber.css'
import {useDispatch, useSelector} from "react-redux";
import {updateTelephoneAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

function RegisterPhoneNumber(props) {
    const phone = useSelector(state => state.userInf.telephone)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="phoneNumber" className="sr-only">Номер телефона</label>
            <input value={phone || ''} onChange={event => dispatch(updateTelephoneAction(event.target.value))}
                type="text" id="phoneNumber" name="phoneNumber" className="form-control" placeholder="88888888888" minLength="11" maxLength="11" size="11" required="required" autoFocus=""/>
        </div>
    );
}

export default RegisterPhoneNumber;
