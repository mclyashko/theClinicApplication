import React, {useEffect} from 'react';
import {useDispatch} from "react-redux";
import logoutRequest from "../../util/request/auth/logoutRequest";
import {clearAction} from "../../reducer/UserInfoReducer/UserInfoReducer";
import {LOGIN_ROUTE} from "../../util/consts";
import {Navigate} from "react-router-dom";

function LogoutPage(props) {
    const dispatch = useDispatch()

    useEffect(() => {
        dispatch(clearAction())
        logoutRequest()
    })

    return (
        <Navigate to={LOGIN_ROUTE}/>
    );
}

export default LogoutPage;
