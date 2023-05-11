import React from 'react'
import './RegisterName.css'
import {useDispatch, useSelector} from "react-redux";
import {updateNameAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

const RegisterName = () => {
    const name = useSelector(state => state.userInf.name)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="name" className="sr-only">Имя</label>
            <input value={name || ''} onChange={event => dispatch(updateNameAction(event.target.value))}
                type="text" id="name" name="name" className="form-control" placeholder="Имя" required="required" autoFocus=""/>
        </div>
    )
}

export default RegisterName
