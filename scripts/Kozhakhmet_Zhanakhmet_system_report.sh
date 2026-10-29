#!/usr/bin/env bash
set -u
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG_FILE="$PROJECT_DIR/logs/Kozhakhmet_Zhanakhmet_system_report.log"
{
 echo "Student: Zhanakhmet Kozhakhmet"
 echo "Project: kozhakhmet-zhanakhmet-student-api"
 echo "Date and time: $(date)"
 echo "Current username: $(whoami)"
 echo "Operating system and kernel:"; uname -a
 echo; echo "CPU information:"
 if command -v sysctl >/dev/null 2>&1; then sysctl -n machdep.cpu.brand_string 2>/dev/null || sysctl -n hw.model 2>/dev/null || true
 elif [ -r /proc/cpuinfo ]; then grep -m 1 'model name' /proc/cpuinfo || true; fi
 echo; echo "Memory information:"
 if command -v free >/dev/null 2>&1; then free -h; elif command -v vm_stat >/dev/null 2>&1; then vm_stat; fi
 echo; echo "Disk usage:"; df -h
 echo; echo "Available disk space for project:"; df -h "$PROJECT_DIR"
} | tee "$LOG_FILE"
