import LoginRegisterPage from "../page/LoginRegisterPage/LoginRegisterPage";
import {DOCTOR_HOME_ROUTE, LOGIN_ROUTE, LOGOUT_ROUTE, PATIENT_HOME_ROUTE} from "./consts";
import DoctorHomePage from "../page/DoctorHomePage/DoctorHomePage";
import PatientHomePage from "../page/PatientHomePage/PatientHomePage";
import LogoutPage from "../page/LogoutPage/LogoutPage";

export const publicRoutes = [
    {
        path: LOGIN_ROUTE,
        Element: LoginRegisterPage
    },
    {
        path: LOGOUT_ROUTE,
        Element: LogoutPage
    }
]

export const doctorRoutes = [
    {
        path: DOCTOR_HOME_ROUTE,
        Element: DoctorHomePage
    }
]

export const patientRoutes = [
    {
        path: PATIENT_HOME_ROUTE,
        Element: PatientHomePage
    }
]
