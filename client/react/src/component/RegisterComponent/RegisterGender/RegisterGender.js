import React from 'react';
import './RegisterGender.css'
import {useDispatch, useSelector} from "react-redux";
import {updateGenderAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

function RegisterGender(props) {
    const gender = useSelector(state => state.userInf.gender)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="gender" className="sr-only">Гендер</label>
            <select value={gender || 'MALE'} onChange={event => {dispatch(updateGenderAction(event.target.value)); console.log(event.target.value);}}
                id="gender" name="gender" className="form-control" required="required" autoFocus="">
                <option value="MALE">М</option>
                <option value="FEMALE">Ж</option>
            </select>
        </div>
    );
}

export default RegisterGender;
