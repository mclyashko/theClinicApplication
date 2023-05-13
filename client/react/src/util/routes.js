import LoginRegisterPage from "../page/LoginRegisterPage/LoginRegisterPage";
import {CONTACT_DETAILS_ROUTE, COVID_STAT_ROUTE, DOCTOR_HOME_ROUTE, LIST_OF_SERVICES_ROUTE, LOGIN_ROUTE, LOGOUT_ROUTE, PATIENT_HOME_ROUTE, QUIZ_ROUTE, REVIEW_ROUTE} from "./consts";
import DoctorHomePage from "../page/DoctorHomePage/DoctorHomePage";
import PatientHomePage from "../page/PatientHomePage/PatientHomePage";
import LogoutPage from "../page/LogoutPage/LogoutPage";
import ContactDetailsPage from "../page/ContactDetailsPage/ContactDetailsPage";
import CovidStatPage from "../page/CovidStatPage/CovidStatPage";
import ListOfServicesPage from "../page/ListOfServicesPage/ListOfServicesPage";
import QuizPage from "../page/QuizPage/QuizPage";
import ReviewPage from "../page/ReviewPage/ReviewPage";

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
    },
    {
        path: LIST_OF_SERVICES_ROUTE,
        Element: ListOfServicesPage
    },
    {
        path: CONTACT_DETAILS_ROUTE,
        Element: ContactDetailsPage
    },
    {
        path: QUIZ_ROUTE,
        Element: QuizPage
    },
    {
        path: COVID_STAT_ROUTE,
        Element: CovidStatPage
    },
    {
        path: REVIEW_ROUTE,
        Element: ReviewPage
    }
]
