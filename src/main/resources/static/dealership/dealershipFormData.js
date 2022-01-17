/**
  Metadata for dealership form elements
*/
import { toggleAddress } from "./dealershipEventListeners.js";

const GENERAL_INFO = "general-info";
const VEHICLE_INFO = "vehicle-info";
const LENDER_INFO = "lender-info";
const DRIVERS_INFO = "drivers-info";

const INPUT = "INPUT";
const SELECT = "SELECT";
const SWITCH = "SWITCH";


export const dealershipElements = [
  {
    id: "referee_name",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Who referred you?",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "referee_company",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "What company referred you?",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "email",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Your email",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "phone",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "phone_facade",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Your phone",
    required: true,
    placeholder: "(xxx) xxx-xxxx",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: false,
    isDisplay: true
  },
  {
    id: "residence_type",
    parentId: GENERAL_INFO,
    type: SELECT,
    value: "",
    label: "Residence Type",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 4,
    options: [
      {value: "", displayName: "Select"},
      {value: "rent", displayName: "Rent"},
      {value: "home", displayName: "Home"},
      {value: "other", displayName: "Other"}
    ],
    onChange: undefined,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "liability_coverage",
    parentId: GENERAL_INFO,
    type: SELECT,
    value: "",
    label: "Liability Coverage",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 4,
    options: [
      {value: "", displayName: "Select"},
      {value: "state-minimum", displayName: "State Minimum"},
      {value: "50-100-50", displayName: "50/100/50"},
      {value: "100-300-100", displayName: "100/300/100"},
      {value: "500-combined", displayName: "500 Combined"}
    ],
    onChange: undefined,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "is_two_month",
    parentId: GENERAL_INFO,
    type: SELECT,
    value: "",
    label: "Resided at current home for less than a year?",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 4,
    options: [
      {value: "", displayName: "Select"},
      {value: "yes", displayName: "Yes"},
      {value: "no", displayName: "No"}
    ],
    onChange: toggleAddress,
    isHidden: false,
    isDisplay: false
  },
  {
    id: "street",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Current Address Line 1",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "street2",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Current Address Line 2",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "city",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Current City",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "state",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Current State",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "zip",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Current Zip",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "prev_street",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Previous Address Line 1",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "prev_street2",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Previous Address Line 2",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 3,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "prev_city",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Previous City",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "prev_state",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Previous State",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  },
  {
    id: "prev_zip",
    parentId: GENERAL_INFO,
    type: INPUT,
    value: "",
    label: "Previous Zip",
    required: true,
    placeholder: "",
    tooltip: "",
    columns: 2,
    onChange: undefined,
    isHidden: true,
    isDisplay: false
  }
];
