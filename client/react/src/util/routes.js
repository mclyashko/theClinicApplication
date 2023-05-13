import LoginRegisterPage from "../page/LoginRegisterPage/LoginRegisterPage";
import {DOCTOR_HOME_ROUTE, LOGIN_ROUTE, PATIENT_HOME_ROUTE} from "./consts";
import DoctorHomePage from "../page/DoctorHomePage/DoctorHomePage";
import PatientHomePage from "../page/PatientHomePage/PatientHomePage";

export const publicRoutes = [
    {
        path: LOGIN_ROUTE,
        Element: LoginRegisterPage
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
