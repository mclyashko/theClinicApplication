import React from 'react';
import './RegisterDateOfBirth.css'
import {useDispatch, useSelector} from "react-redux";
import {updateDateOfBirthAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

function RegisterDateOfBirth(props) {
    const dateOfBirth = useSelector(state => state.userInf.dateOfBirth)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="dateOfBirth" className="sr-only">Дата рождения</label>
            <input value={dateOfBirth || '01-01-2022'} onChange={event => dispatch(updateDateOfBirthAction(event.target.value))}
                type="date" id="dateOfBirth" name="dateOfBirth" className="form-control" placeholder="01-01-2022" min="1917-11-07" max="2022-12-31" required="required" autoFocus=""/>
        </div>
    );
}

export default RegisterDateOfBirth;
