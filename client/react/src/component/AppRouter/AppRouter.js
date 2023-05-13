import {Routes, Route, Navigate} from "react-router-dom";
import {DOCTOR_ROLE, LOGIN_ROUTE, PATIENT_HOME_ROUTE, PATIENT_ROLE} from "../../util/consts";
import {doctorRoutes, patientRoutes, publicRoutes} from "../../util/routes";
import React from "react";
import {useSelector} from "react-redux";

export const AppRouter = () => {
    const role = useSelector(state => state.userInf.role)

    return (
        <Routes>
            {publicRoutes.map(({path, Element}) =>
                <Route key={path} path={path} element={<Element/>} exact></Route>
            )}
            {role === DOCTOR_ROLE && doctorRoutes.map(({path, Element}) =>
                <Route key={path} path={path} element={<Element/>} exact></Route>
            )}
            {role === PATIENT_ROLE && patientRoutes.map(({path, Element}) =>
                <Route key={path} path={path} element={<Element/>} exact></Route>
            )}
            <Route path = "*" element={<Navigate to = {LOGIN_ROUTE} replace/>}></Route>
        </Routes>
    )
}

export default AppRouter
